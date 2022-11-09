package com.example.recordatorio.Clases.message;

import com.example.recordatorio.Clases.recordatorio.RecordatorioEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message2 {
    private boolean sucess;
    private String message;
    private RecordatorioEntity data;
    
    public Message2() {
    }

    public Message2(boolean sucess, String message, RecordatorioEntity data) {
        this.sucess = sucess;
        this.message = message;
        this.data = data;
    }

    
}
