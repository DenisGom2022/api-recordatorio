package com.example.recordatorio.Clases.message;

import java.util.List;

import com.example.recordatorio.Clases.recordatorio.RecordatorioEntity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Message1 {
    private boolean sucess;
    private String message;
    private List<RecordatorioEntity> data;

    public Message1(){
        
    }

    public Message1(boolean sucess, String message, List<RecordatorioEntity> data) {
        this.sucess = sucess;
        this.message = message;
        this.data = data;
    }
}
