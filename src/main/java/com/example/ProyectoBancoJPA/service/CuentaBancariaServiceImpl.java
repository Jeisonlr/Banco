package com.example.ProyectoBancoJPA.service;

import com.example.ProyectoBancoJPA.dto.CuentaBancariaDTO;
import com.example.ProyectoBancoJPA.exceptions.ApiRequestException;
import com.example.ProyectoBancoJPA.exceptions.CuentaNoEncontradaException;
import com.example.ProyectoBancoJPA.model.Cliente;
import com.example.ProyectoBancoJPA.model.CuentaBancaria;
import com.example.ProyectoBancoJPA.repository.CuentaBancariaRepository;
import com.example.ProyectoBancoJPA.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Random;

@Service
public class CuentaBancariaServiceImpl implements CuentaBancariaService {
    private final CuentaBancariaRepository cuentaBancariaRepository;
    private final ClienteRepository clienteRepository;

    public CuentaBancariaServiceImpl(CuentaBancariaRepository cuentaBancariaRepository, ClienteRepository clienteRepository) {
        this.cuentaBancariaRepository = cuentaBancariaRepository;
        this.clienteRepository = clienteRepository;
    }

    @Override
    public CuentaBancaria createCuentaBancaria(CuentaBancariaDTO cuentaBancariaDTO) throws ArithmeticException, ApiRequestException {

        BigDecimal saldoMinimo = new BigDecimal("20000");
        Random random = new Random();
        Integer idcuenta = random.nextInt(1000);

        // Validar que el balance sea mayor o igual a $20000
        if (cuentaBancariaDTO.getBalance().compareTo(saldoMinimo) < 0) {
            throw new ApiRequestException("El saldo mínimo requerido es de $20.000 COP");
        }
        // Obtener el cliente por cédula
        Optional<Cliente> clienteExistenteOptional = clienteRepository.findByCedula(cuentaBancariaDTO.getCedulaCliente());

        if (clienteExistenteOptional.isPresent()) {
            Cliente clienteExistente = clienteExistenteOptional.get();
            CuentaBancaria cuentaBancaria = new CuentaBancaria();
            cuentaBancaria.setIdCuenta(idcuenta);
            cuentaBancaria.setCliente(clienteExistente);
            cuentaBancaria.setBalance(cuentaBancariaDTO.getBalance());
            cuentaBancaria.setFecha_apertura(cuentaBancariaDTO.getFecha_apertura());
            cuentaBancaria.setEstado("Activa");
            cuentaBancaria.setBanco("Bancorporación Makaia");

            return cuentaBancariaRepository.save(cuentaBancaria);
        } else {
            throw new ApiRequestException("No se puede crear la cuenta porque el cliente no existe.");
        }
    }

    @Override
    public List<CuentaBancaria> getAllCuentasBancarias() {
        return (List<CuentaBancaria>) cuentaBancariaRepository.findAll();
    }

    @Override
    public CuentaBancaria getCuentaBancariaById(Integer idCuenta) {
        return cuentaBancariaRepository.findById(idCuenta)
                .orElseThrow(() -> new NoSuchElementException("No se encontró la cuenta bancaria con ID: " + idCuenta));
    }

    @Override
    public CuentaBancaria updateCuentaBancaria(Integer idCuenta, CuentaBancaria cuentaBancariaActualizada) throws CuentaNoEncontradaException {
        Optional<CuentaBancaria> cuentaBancariaExistenteOptional = cuentaBancariaRepository.findById(idCuenta);

        if (cuentaBancariaExistenteOptional.isPresent()) {
            CuentaBancaria cuentaBancariaExistente = cuentaBancariaExistenteOptional.get();

            cuentaBancariaExistente.setBalance(cuentaBancariaActualizada.getBalance());
            cuentaBancariaExistente.setEstado(cuentaBancariaActualizada.getEstado());

            return cuentaBancariaRepository.save(cuentaBancariaExistente);
        } else {
            throw new CuentaNoEncontradaException("No se encontró la cuenta bancaria con ID: " + idCuenta);
        }
    }

    @Override
    public void deleteCuentaBancaria(Integer idCuenta)  {
        Optional<CuentaBancaria> cuentaBancariaOptional = cuentaBancariaRepository.findById(idCuenta);

        if (cuentaBancariaOptional.isPresent()) {
            CuentaBancaria cuentaBancaria = cuentaBancariaOptional.get();

            if (cuentaBancaria.getBalance().compareTo(BigDecimal.ZERO) != 0) {
                throw new ArithmeticException("No debe haber fondos en la cuenta para su eliminación");
            }
            cuentaBancariaRepository.delete(cuentaBancaria);
        } else {
            throw new CuentaNoEncontradaException("No se encontró la cuenta bancaria con ID: " + idCuenta);
        }
    }
}