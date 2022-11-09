package com.example.recordatorio.Clases.recordatorio;

import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RestController;

import com.example.recordatorio.Clases.message.Message1;
import com.example.recordatorio.Clases.message.Message2;


@CrossOrigin(maxAge = 3360)
@RestController
public class RecordatorioController {
    @Autowired
    RecordatorioService service;

    @GetMapping("/recorda")
    public ResponseEntity<?> getRecord(){
        
        List<RecordatorioEntity> data = service.findAll();
        Message1 msg = new Message1(true, "correcto", data);
        return ResponseEntity.status(HttpStatus.OK).body(msg);
    }

    @GetMapping("/recorda/{id}")
    public ResponseEntity<Message2> getOneRecor(@PathVariable int id){
        RecordatorioEntity data = service.search(id);
        if (data == null){
            Message2 msg = new Message2(false, "Producto no existe", new RecordatorioEntity());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
        }
        Message2 msg = new Message2(true, "Producto encontrado", data);
        return ResponseEntity.status(HttpStatus.OK).body(msg);
    }

    @PostMapping("/recorda")
    public ResponseEntity<Object> guardar(@Valid @RequestBody RecordatorioEntity recordatorio){
        if(recordatorio.getNombreActividad() == null || recordatorio.getDescripcion() == null || recordatorio.getResponsable() == null || recordatorio.getFecha() == null){
            Message2 msg = new Message2(false, "Completar campos", recordatorio);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg);
        } else {
            RecordatorioEntity data = service.save(recordatorio);
            Message2 msg = new Message2(true, "Completar campos", data);
            return ResponseEntity.status(HttpStatus.OK).body(msg);
        }
        
    }

    @DeleteMapping("/recorda/{id}")
    public ResponseEntity<Message2> eliminar(@PathVariable int id){
        try {
            service.delete(id);
            Message2 msg = new Message2(true, "Eliminado con éxito", null);
            return ResponseEntity.status(HttpStatus.OK).body(msg);
        } catch (Exception e) {
            Message2 msg = new Message2(false, "Error al eliminar", null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(msg);
        }
    }

    @PutMapping("/recorda/{id}")
    public ResponseEntity<Message2> modificar(@PathVariable int id, @RequestBody RecordatorioEntity recordatorio){
        RecordatorioEntity find = service.search(id);
        if(recordatorio.getNombreActividad() == null || recordatorio.getDescripcion() == null || recordatorio.getResponsable() == null || recordatorio.getFecha() == null){
            Message2 msg = new Message2(false, "Completar campos", recordatorio);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg);
        }
        if (find == null){
            Message2 msg = new Message2(false, "recordatorio no existe", new RecordatorioEntity());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
        }
        recordatorio.setId(id);
        service.save(recordatorio);
        Message2 msg = new Message2(true, "Modificado con éxito", recordatorio);
        return ResponseEntity.status(HttpStatus.OK).body(msg);
    }

    @GetMapping("/saludo")
    public String saludo(){
        System.out.println("Entre");
        return "hola Luis";
    }
}
