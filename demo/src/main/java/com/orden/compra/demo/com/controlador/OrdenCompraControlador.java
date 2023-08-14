package com.orden.compra.demo.com.controlador;

import com.orden.compra.demo.com.Dto.OdenCompraDetaDto;
import com.orden.compra.demo.com.Dto.OrdenCompraDto;
import com.orden.compra.demo.com.modelo.OrdenCompra;
import com.orden.compra.demo.com.modelo.OrdenCompraDetalle;
import com.orden.compra.demo.com.repositorio.OrdenCompraDetaRepositorio;
import com.orden.compra.demo.com.repositorio.OrdenCompraRepositorio;
import com.orden.compra.demo.com.repositorio.ordenCompraDeaRepository;
import com.orden.compra.demo.com.repositorio.ordenCompraRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/apiordencompra")
public class OrdenCompraControlador {

    private   final Logger LOG = Logger.getLogger(OrdenCompraControlador.class.getName());
    @Autowired
    OrdenCompraRepositorio ordenCompaRepositorio;
    @Autowired
    ordenCompraRepository ordenRepository;

    @Autowired
    ordenCompraDeaRepository ordenDetaRepository;

    @Autowired
    OrdenCompraDetaRepositorio ordenCompaDetaRepositorio;

    @GetMapping("/apiordencompralist")
    public ResponseEntity<?> getAllOrdenCompras() {
        try {
            List<OrdenCompra> ordencompras = new ArrayList<OrdenCompra>();
            List<OdenCompraDetaDto> ordenCompadetaDto = new ArrayList<OdenCompraDetaDto>();
            List<OrdenCompraDto> ordenCompraDto = new ArrayList<OrdenCompraDto>();
            ordencompras = ordenCompaRepositorio.buscarOrdenCompras();
            if (ordencompras.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            // ordencompras=ordenRepository.findAll();

            LOG.info("Obteniendo objetos");
           /* ordencompras.stream().forEach((f) -> {
                LOG.log(Level.INFO, "OrdenCompra: {0}", f);
            });*/

            for (OrdenCompra undto : ordencompras) {
                OrdenCompraDto compDto=new OrdenCompraDto();
                compDto.setIdOrdCompra(undto.getOrdenId());
                compDto.setFecha(undto.getFechaOrden());
                compDto.setIdCliente(undto.getClienteId());
                compDto.setPrecioTotal(undto.getPrecioTotal());
                int i=0;
                for(OrdenCompraDetalle dt : undto.getDetalle()){
                    OdenCompraDetaDto deta=new OdenCompraDetaDto();
                    deta.setOrdenPedidoId(undto.getDetalle().get(i).getOrdenDetallePK().getOrdenId());
                    deta.setOrderDetaId(undto.getDetalle().get(i).getOrdenDetallePK().getDetaId());
                    deta.setDescProd(undto.getDetalle().get(i).getDescripcion());
                    deta.setNombreProd(undto.getDetalle().get(i).getNombreProd());
                    deta.setIdProducto(undto.getDetalle().get(i).getProductoId());
                    deta.setCantProducto(undto.getDetalle().get(i).getCantProducto());
                    deta.setPrecioProducto(undto.getDetalle().get(i).getPrecioProd());
                    i++;
                    compDto.getDetalle().add(deta);

                }
                ordenCompraDto.add(compDto);
            }

            return new ResponseEntity<>(ordenCompraDto, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Error "+e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/crearOrdenCompra")
        public ResponseEntity<OrdenCompraDto> createOrdenCompra(@RequestBody OrdenCompraDto ordenCom) {
        try {
            LOG.info("Insertando objeto factura");
            OrdenCompra ordenCompra = new OrdenCompra();
            ordenCompra.setOrdenId(ordenCom.getIdOrdCompra());
            ordenCompra.setClienteId(ordenCom.getIdCliente());
            ordenCompra.setFechaOrden(ordenCom.getFecha());
            ordenCompra.setPrecioTotal(ordenCom.getPrecioTotal());
            ordenRepository.save(ordenCompra);
            LOG.warning("Datos Encabezados Insertardos ");

            // OrdenCompraDetalle compDto=new OrdenCompraDetalle();
            for(OdenCompraDetaDto DetalleDto : ordenCom.getDetalle()){
                OrdenCompraDetalle det1 = new OrdenCompraDetalle(ordenCom.getIdOrdCompra(),DetalleDto.getOrderDetaId());
                det1.setNombreProd(DetalleDto.getNombreProd());
                det1.setDescripcion(DetalleDto.getDescProd());
                det1.setCantProducto(DetalleDto.getCantProducto());
                det1.setProductoId(DetalleDto.getIdProducto());
                det1.setPrecioProd(DetalleDto.getPrecioProducto());
                det1.setOrdencompra(ordenCompra);
                ordenDetaRepository.save(det1);
                LOG.warning("Datos Encabezados Insertardos ");

            }
            LOG.warning("Datos OrdenCompra Insertardos ");


           // LOG.log(Level.INFO, "detalle 2 insertada{0}", det2);

            return new ResponseEntity<>(ordenCom, HttpStatus.CREATED);
        } catch (Exception e) {
            LOG.log(Level.WARNING, "Error al insertar OrdenCompra", e.getMessage());
            System.out.println("ERROR  "+e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
