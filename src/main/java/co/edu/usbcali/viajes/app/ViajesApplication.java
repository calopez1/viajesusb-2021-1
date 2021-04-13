package co.edu.usbcali.viajes.app;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;


import co.edu.usbcali.viajes.app.domain.Destino;
import co.edu.usbcali.viajes.app.domain.TipoDestino;
import co.edu.usbcali.viajes.app.dto.TipoDestinoDTO;
import co.edu.usbcali.viajes.app.repository.DestinoRepository;
import co.edu.usbcali.viajes.app.repository.TipoDestinoRepository;
import co.edu.usbcali.viajes.app.service.DestinoService;
import co.edu.usbcali.viajes.app.service.TipoDestinoService;
import co.edu.usbcali.viajes.app.utils.Constantes;

@SpringBootApplication
public class ViajesApplication implements CommandLineRunner{
	
	private final static Logger log = LoggerFactory.getLogger(ViajesApplication.class);


	@Autowired
	private TipoDestinoService tipoDestinoService;
	
	@Autowired
	private DestinoService destinoService;
	
	public static void main(String[] args) {
		SpringApplication.run(ViajesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
//	   buscarPorId(2);
//	   consultarTiposDestino();
//	   eliminarTipoDestino(2);
//	   buscarTodosTiposDestinoOrdenados();
//	   consultaTipoDestinoPorCodigo();
//	   consultaTiposDestinoPorEstadoPorCodigo();
//	   guardarDestino();
//	   eliminarDestino();
//	   actualizarDestino();
//	   consultarDestinoPorCodigoPorEstado();
//	   consultarDestinoConTipoDestino();
	   
	}
	
	private void buscarPorId(Integer id) {
		
		TipoDestino tipoDestino = null;
		
		try {
			
			//Se consulta el tipo de destino por id
			tipoDestino = tipoDestinoService.buscarPorId(id);
			
			log.info("Se encontró el tipo destino: "+ tipoDestino.getCodigo() + " - " + tipoDestino.getNombre());
			
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	
	}
	
	
	private void consultarTiposDestino() {

		List<TipoDestino> lstTipoDestino = null;
		
		try {
			//Se consulta todos los tipos de destino
			lstTipoDestino = tipoDestinoService.consultarTiposDestino();
			
			//Se imprime los tipos de destino
			for (TipoDestino tipoDestino : lstTipoDestino) {
				log.info("Tipo destino: "+tipoDestino.getCodigo() + " - " + tipoDestino.getNombre());
			}
			
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
	

	private void eliminarTipoDestino(Integer id) {
		
		try {
			//Se elimina el registro pasandole el id
			TipoDestino tide = new TipoDestino();
			tide.setIdTide(id);
			
			tipoDestinoService.eliminarTipoDestino(tide);
		}catch (Exception e) {
			log.error(e.getMessage());
		}
		
		
	}
	
	  
   //Consultar por ordenamiento
   private void buscarTodosTiposDestinoOrdenados() {
	   
	   List<TipoDestino> tiposDestino = null;
	   
	   try {
		   
		   tiposDestino = tipoDestinoService.buscarTodosTiposDestinoOrdenados();
		  
		   for(TipoDestino tide: tiposDestino) {
			   log.info("Tipo destino: "+tide.getCodigo());
		   }
			
	   }catch (Exception e) {
		   log.error(e.getMessage());
	   }
	   
   }
	
   
   // Se consulta un tipo de destino por codigo
   private void consultaTipoDestinoPorCodigo() {
	   
	   TipoDestino tipoDestino = null;
	   
	   try {
		    tipoDestino = tipoDestinoService.consultaTipoDestinoPorCodigo("PLAYA");
		    log.info("Tipo destino "+tipoDestino.getCodigo());
			
	   }catch (Exception e) {
		   log.error(e.getMessage());
	   }
		
  }
  
   private void consultaTiposDestinoPorEstadoPorCodigo() {
	   
	   List<TipoDestino> tipoDestino = null;
			   
	   try {
		   
		   tipoDestino = tipoDestinoService.consultaTiposDestinoPorEstadoPorCodigo("A", "PLAYA");
		   
		   for (TipoDestino tipoDestino2 : tipoDestino) {
			   log.info("Tipo destino "+tipoDestino2.getCodigo());

		   }
		   
	   }catch (Exception e) {
		   log.error(e.getMessage());
	   }

   }
	
   private void guardarDestino() {

	   try {
		   
			//Se consulta el tipo de destino
			TipoDestino tipoDestino = tipoDestinoService.consultaTipoDestinoPorCodigo("PLAYA");
			
			//Se crea el destino
			Destino destino = new Destino();
			destino.setAire(Constantes.SI);
			destino.setMar(Constantes.SI);
			destino.setTierra(Constantes.NO);
			destino.setCodigo("EJEMP");
			destino.setDescripcion("SITIO TURISTICO DE EJEMPLO");
			destino.setEstado(Constantes.ACTIVO);
			destino.setFechaCreacion(new Date());
			destino.setNombre("EJEMPLO");
			destino.setTipoDestino(tipoDestino);
			destino.setUsuCreador("CLOPEZ");
			
			//Se guarda el destino
			destinoService.guardarDestino(destino);
			
			log.info("Guardado exitosamente");
		
	   }catch (Exception e) {
		   log.error(e.getMessage());
	   }
		
		
	}
	
   private void eliminarDestino() {
		
		try {
			
			//Se consulta el destino a eliminar
			Destino destino = destinoService.consultarDestinoPorCodigoPorEstado("EJEMP", Constantes.ACTIVO);
			
			//Se llama al service para eliminar
			destinoService.eliminarDestino(destino);
			
		}catch (Exception e) {
			 log.error(e.getMessage());
		}
		
	}
   
   private void actualizarDestino() {
		
	   Destino destino = null;
	   
	   try {
		   	//Se consulta el destino a actualziar
			destino = destinoService.consultarDestinoPorCodigoPorEstado("EJEMP", Constantes.ACTIVO);
			
			//Se setean nuevos datos
			destino.setNombre("Ejemplo modificado");
			destino.setUsuModificador("CLOPEZM");
			//Se guarda el destino
			destinoService.actualizarDestino(destino);
			
		} catch (Exception e) {
			 log.error(e.getMessage());
		}

	}
	
	
	private void consultarDestinoPorCodigoPorEstado() {

		Destino destino = null;
				
		try {
			//Se consulta el destino a eliminar			
			destino = destinoService.consultarDestinoPorCodigoPorEstado("EJEMP", Constantes.ACTIVO);

			log.info("Destino: "+destino.getCodigo() + " - "+destino.getNombre());

		} catch (Exception e) {
			 log.error(e.getMessage());
		}
		

		
	}
	
	private void consultarDestinoConTipoDestino() {
		   
		List<Destino> lstDestino =  null;
		
		try {
			
			lstDestino = destinoService.consultarDestinoPorCodigoTipoDestino("PLAYA");
			  
			for (Destino destino : lstDestino) {
				log.info("Destino "+destino.getCodigo());
			 }
			
		}catch (Exception e) {
			 log.error(e.getMessage());
		}
 
	  }
	   

   
   
}
