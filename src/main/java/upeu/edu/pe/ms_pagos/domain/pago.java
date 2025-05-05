package upeu.edu.pe.ms_pagos.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "pagos")
public class pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "monto")
    private Double monto;

    @Column(name = "metodo_pago")
    private String metodoPago;

    @Column(name = "fecha_pago")
    private String fechaPago;

    @Column(name = "estado")
    private String estado;

   /* @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario; // Relación con el usuario (suponiendo que tienes una entidad Usuario)
*/
}

