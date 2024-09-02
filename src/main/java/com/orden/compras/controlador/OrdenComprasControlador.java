package com.orden.compras.controlador;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.orden.compras.Dto.OrdenCompraDetalleDto;
import com.orden.compras.Dto.OrdenCompraDto;
import com.orden.compras.modelo.OrdenCompra;
import com.orden.compras.modelo.OrdenCompraDetalle;

import com.orden.compras.servicio.OrdenCompraService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
//import java.util.logging.Level;
//import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/apiCompras")
public class OrdenComprasControlador {
	//private static   final Logger LOG = Logger.getLogger(OrdenComprasControlador.class.getName());
	//	 LOG.log(Level.INFO, "Error", e.getMessage());
	
	private static final Logger LOG = LoggerFactory.getLogger(OrdenComprasControlador.class.getName());
	/*
	LOG.trace("for tracing purpose");
	LOG.debug("for debugging purpose");
	LOG.info("for informational purpose");
	LOG.warn("for warning purpose");
	LOG.error("for logging errors");
	*/
	@Autowired
    private OrdenCompraService service;
	
	@GetMapping("/comprasList")
	public ResponseEntity<?> getAllShopping(@RequestParam(required = false) String title) {
    //public String getAllTutorials(@RequestParam(required = false) String title) {
		 LOG.info("Entro al Servicio de Listar Ordenes");
		String json="";
		try {
			List<OrdenCompra> ordComp = new ArrayList<OrdenCompra>();


			if (title == null)					//repositorio.findAll().forEach(prof::add);
				ordComp=service.listar();
			/*
			else
				ordenComprasRepository.findByTitleContaining(title).forEach(ordenCompra::add);
             */
			if (ordComp.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				
			}
		   // LOG.info("Listar Ordenes de Compras\n");
		    
		    ordComp.stream().forEach((f) -> {
           // LOG.log(Level.INFO, "Profesores: {0}", f);
            });
			
			 List<OrdenCompraDto> comprasDtoList = new ArrayList<OrdenCompraDto>();
			
			
			for (OrdenCompra comp : ordComp) {
				OrdenCompraDto compDto=new OrdenCompraDto();
  
				compDto.setIdOrdCompra(comp.getIdOrdCompra());
				compDto.setNombrecliente(comp.getNombrecliente());
				compDto.setIdCliente(comp.getIdCliente());
				compDto.setDescripcion_orden(comp.getDescripcion_orden());
				compDto.setFecha(comp.getFecha());
				compDto.setTotal(comp.getTotal());
                int i=0;
                for(OrdenCompraDetalle ordDt : comp.getOrdenCompraDetalle()){
                	OrdenCompraDetalleDto deta=new OrdenCompraDetalleDto();
                	deta.setIdDetalle(comp.getOrdenCompraDetalle().get(i).getIdDetalle());
                	deta.setIdOrdenCompra(comp.getOrdenCompraDetalle().get(i).getOrdenCompra().getIdOrdCompra());
                	deta.setCantidad(comp.getOrdenCompraDetalle().get(i).getCantidad());
                	deta.setIdProducto(comp.getOrdenCompraDetalle().get(i).getIdProducto());
                	deta.setNombreProducto(comp.getOrdenCompraDetalle().get(i).getNombreProducto());
                	deta.setPrecioProducto(comp.getOrdenCompraDetalle().get(i).getPrecioProducto());
                	

                	System.out.println("id "+deta.getIdDetalle() + "idOrden: "+ deta.getIdOrdenCompra() +"idproducto: " +deta.getIdProducto());
                    i++;
                    compDto.getOrdenCompraDetalle().add(deta);

                    

                }
                comprasDtoList.add(compDto);
            }
			
			 json = new Gson().toJson(comprasDtoList);
			System.out.println(json);
			
			 LOG.info("Obteniendo objetos compras");
			 ordComp.stream().forEach((f) -> {
	                LOG.info("OrdenCompra: {0}", f);
	            });
			 
			LOG.info("Lista json OrdenesCompra",json);
			return new ResponseEntity<>(comprasDtoList, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("Error"  + e.getMessage());
			 LOG.error("Error", e.getMessage());
			 
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
	}
	
	@PostMapping("/crearOrdenCompra")
    public ResponseEntity<OrdenCompra> createOrdenCompra(@RequestBody(required = false) OrdenCompra ordcomp) {
    try {
        LOG.info("Insertando objeto factura");        
        //inserOrden();
 OrdenCompra ordenCompra=new OrdenCompra(ordcomp.getIdOrdCompra(), ordcomp.getIdCliente(), ordcomp.getNombrecliente(),ordcomp.getDescripcion_orden(), new Date(),ordcomp.getTotal());
        
        List<OrdenCompraDetalle> detaList= new ArrayList<OrdenCompraDetalle>();
        OrdenCompraDetalle deta =new OrdenCompraDetalle();
        for(OrdenCompraDetalle dt: ordcomp.getOrdenCompraDetalle()) {
        	//deta.setIdDetalle(dt.getIdDetalle());
        	//deta.setIdProducto(dt.getCantidad());
        	//deta.setNombreProducto(dt.getNombreProducto());
        	//deta.setCantidad(dt.getCantidad());
        	//deta.setOrdenCompra(ordenCompra);      	
        	detaList.add(new OrdenCompraDetalle(dt.getIdDetalle(),ordenCompra,dt.getCantidad(),dt.getIdProducto(), dt.getNombreProducto(),dt.getPrecioProducto()));           
        	//ordenCompra.setOrdenCompraDetalle(OrdeCompDeta);            
        	//detaList.add(deta);
        	
        }
        ordenCompra.setOrdenCompraDetalle(detaList);
        
        
        service.guardar(ordenCompra);
              
        return new ResponseEntity<>(ordcomp, HttpStatus.CREATED);
    } catch (Exception e) {
        LOG.error("Error al insertar Orden Compra", e.getMessage());
        System.out.println("ERROR  "+e.getMessage());
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	}
	
	void inserOrden() {
		LOG.info("Insertando objeto factura");        
        OrdenCompra ordenCompra=new OrdenCompra("Orde-R11", 1, "Oscar Rivas","Orden Construccion",new Date(),new BigDecimal(80));
        
        List<OrdenCompraDetalle> OrdeCompDeta= new ArrayList<OrdenCompraDetalle>();
        OrdeCompDeta.add(new OrdenCompraDetalle("Det-1",ordenCompra,1,1, "Pala",new BigDecimal(10)));
        OrdeCompDeta.add(new OrdenCompraDetalle("Det-2",ordenCompra,2,1, "Carreta ",new BigDecimal(60)));
        OrdeCompDeta.add(new OrdenCompraDetalle("Det-3",ordenCompra,3,1, "Cemento",new BigDecimal(10)));
        ordenCompra.setOrdenCompraDetalle(OrdeCompDeta);
        
        service.guardar(ordenCompra);
		
	}
	
	
	
	
}
