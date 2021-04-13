package co.edu.usbcali.viajes.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbcali.viajes.app.domain.TipoDestino;
import co.edu.usbcali.viajes.app.service.TipoDestinoService;

@RestController
@RequestMapping("/api/tipoDestino")
public class TipoDestinoRestController {

	@Autowired
	private TipoDestinoService tipoDestinoService;
	
	@GetMapping("/getTiposDestino")
	public ResponseEntity<?> buscarTodosTiposDestino(){
		try {			
			return ResponseEntity.ok().body(tipoDestinoService.buscarTodosTiposDestinoOrdenados());									
		} catch (Exception e) {			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();			
		}
		
	}
	
	@GetMapping("/getTipoDestinoPorCodigo")
	public ResponseEntity<?> buscarTipoDestinoPorCodigo(@RequestParam("codigo") String codigo, @RequestParam("nombre") String nombre){
		try {			
			return ResponseEntity.ok().body(tipoDestinoService.consultaTipoDestinoPorCodigo(nombre));									
		} catch (Exception e) {			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();			
		}
		
	}
	
}
