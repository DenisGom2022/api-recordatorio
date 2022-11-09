package com.example.recordatorio.Clases.recordatorio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RecordatorioService {
    @Autowired
    RecodatorioRepository repository;

    public List<RecordatorioEntity> findAll(){
        return repository.findAll();
    }

    public RecordatorioEntity findOne(int id){
        Optional<RecordatorioEntity> data =  repository.findById(id);
        System.out.println(data);
        return Optional.ofNullable(data.get()).orElse(null);
    }

    public RecordatorioEntity search(int id){
        RecordatorioEntity data = repository.search(id);
        return data;
    }

    public RecordatorioEntity save(RecordatorioEntity a){
        return repository.save(a);
    }

    public void delete(int id){
        repository.deleteById(id);
    }

}
