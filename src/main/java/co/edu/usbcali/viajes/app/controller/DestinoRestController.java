package co.edu.usbcali.viajes.app.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbcali.viajes.app.domain.Destino;
import co.edu.usbcali.viajes.app.domain.TipoDestino;
import co.edu.usbcali.viajes.app.dto.DestinoDTO;
import co.edu.usbcali.viajes.app.service.DestinoService;
import co.edu.usbcali.viajes.app.service.TipoDestinoService;
import co.edu.usbcali.viajes.app.utils.Constantes;

@RestController
@RequestMapping("/api/destino")
public class DestinoRestController {

	@Autowired
	private DestinoService destinoService;
	
	@Autowired
	private TipoDestinoService tipoDestinoService;
	
	@PostMapping("/guardarDestino")
	public ResponseEntity<?> guardarDestino(@RequestBody DestinoDTO destinoDTO){
		
		try {		
			
			//Se consulta el tipo de destino
			TipoDestino tipoDestino = tipoDestinoService.consultaTipoDestinoPorCodigo(destinoDTO.getTipoDestinoCodigo());
			
			//Se crea el destino
			Destino destino = new Destino();
			destino.setAire(destinoDTO.getAire());
			destino.setMar(destinoDTO.getMar());
			destino.setTierra(destinoDTO.getTierra());
			destino.setCodigo(destinoDTO.getCodigo());
			destino.setDescripcion(destinoDTO.getDescripcion());
			destino.setEstado(destinoDTO.getEstado());
			destino.setFechaCreacion(new Date());
			destino.setNombre(destinoDTO.getNombre());
			destino.setTipoDestino(tipoDestino);
			destino.setUsuCreador(destinoDTO.getUsuCreador());
			
			destinoService.guardarDestino(destino);
			
			return ResponseEntity.ok().body(destino);	
		
		} catch (Exception e) {			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();			
		}		
		
	}
	
	@PutMapping("/actualizarDestino")
	public ResponseEntity<?> actualizarDestino(@RequestBody DestinoDTO destinoDTO){
		
		try {		
			
			//Se consulta el tipo de destino
			TipoDestino tipoDestino = tipoDestinoService.consultaTipoDestinoPorCodigo(destinoDTO.getTipoDestinoCodigo());
			
			//Se crea el destino
			Destino destino = new Destino();
			destino.setIdDest(destinoDTO.getIdDest());
			destino.setAire(destinoDTO.getAire());
			destino.setMar(destinoDTO.getMar());
			destino.setTierra(destinoDTO.getTierra());
			destino.setCodigo(destinoDTO.getCodigo());
			destino.setDescripcion(destinoDTO.getDescripcion());
			destino.setEstado(destinoDTO.getEstado());
			destino.setFechaCreacion(new Date());
			destino.setNombre(destinoDTO.getNombre());
			destino.setTipoDestino(tipoDestino);
			destino.setUsuCreador(destinoDTO.getUsuCreador());
			destino.setUsuModificador(destinoDTO.getUsuModificador());
			destino.setFechaModificacion(destinoDTO.getFechaModificacion());

			destinoService.actualizarDestino(destino);
			
			return ResponseEntity.ok().body(destino);	
		
		} catch (Exception e) {			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());			
		}		
		
	}
	
	@DeleteMapping("/eliminarDestino/{id}")
	public ResponseEntity<?> eliminarDestino(@PathVariable("id") Integer idDestino){
		

		try {		

			Destino destino = new Destino();
			destino.setIdDest(idDestino);
			destinoService.eliminarDestino(destino);
			
			return ResponseEntity.ok().body("Se eliminó satisfactoriamente");	
		
		} catch (Exception e) {			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());			
		}		
		
		
	}
	
}
