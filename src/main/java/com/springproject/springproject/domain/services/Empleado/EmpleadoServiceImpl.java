package com.springproject.springproject.domain.services.Empleado;

import org.springframework.stereotype.Service;

import com.springproject.springproject.persistence.repositories.EmpleadoRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

import com.springproject.springproject.persistence.entities.Empleado;
import java.util.List;
import java.util.Optional;


@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    private EmpleadoRepository empleadoRepository;

    public EmpleadoServiceImpl(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    public List<Empleado> findAll(){
        return empleadoRepository.findAll();
    }

    @Override
    public Optional<Empleado> findById(Long id){
        return empleadoRepository.findById(id);
    
    }

    @Override
    @Transactional
    public Empleado save(Empleado empleado){
        return empleadoRepository.save(empleado);
    }

    @Override
    @Transactional
    public Empleado update(Long id, Empleado empleado){
        if(!empleadoRepository.existsById(id)){
            throw new EntityNotFoundException("El empleado con id" + id + " no fue encontrado");
        }
        empleado.setIdEmpleado(id);
        return empleadoRepository.save(empleado);
    }
    
    @Override
    @Transactional
    public Optional<Empleado> delete(Long id){
        Optional<Empleado> empleado = empleadoRepository.findById(id);
        if (empleado.isPresent()){
            empleadoRepository.setEmpleadoNull(id);
            empleadoRepository.setJefeNull(id);
            empleadoRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("El empleado con id" + id + "no fue encontrado");
        }
        return empleado;
    }

}
