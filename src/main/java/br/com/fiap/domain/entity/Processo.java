package br.com.fiap.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "T_PROCESSO", uniqueConstraints = {
        @UniqueConstraint(name = "UK_NR_PROCESSO", columnNames = "NR_NUMERO")
})
public class Processo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PROCESSO")
    @SequenceGenerator(name = "SQ_PROCESSO", sequenceName = "SQ_PROCESSO")
    @Column(name = "ID_PROCESSO")
    private Long id;

    @Column(name = "NR_PROCESSO", nullable = false)
    private String numero;

    @Column(name = "PB_PROCESSO")
    private Boolean proBono;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "ID_ADVOGADO",
            referencedColumnName = "ID_ADVOGADO",
            foreignKey = @ForeignKey(name = "FK_PROCESSO_ADVOGADO"),
            nullable = false
    )
    private Advogado advogado;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "ID_TP_ACAO",
            referencedColumnName = "ID_TP_ACAO",
            foreignKey = @ForeignKey(name = "FK_ID_TP_ACAO"),
            nullable = false
    )
    private TipoDeAcao tipoDeAcao;


    public Processo() {
    }

    public Processo(Long id, String numero, Boolean proBono, Advogado advogado, TipoDeAcao tipoDeAcao) {
        this.setId(id);
        this.setNumero(numero);
        this.setProBono(proBono);
        this.setAdvogado(advogado);
        this.setTipoDeAcao(tipoDeAcao);
    }

    public Long getId() {
        return id;
    }

    public Processo setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNumero() {
        return numero;
    }

    public Processo setNumero(String numero) {
        this.numero = numero;
        return this;
    }

    public Boolean getProBono() {
        return proBono;
    }

    public Processo setProBono(Boolean proBono) {
        this.proBono = proBono;
        return this;
    }

    public Advogado getAdvogado() {
        return advogado;
    }

    public Processo setAdvogado(Advogado advogado) {
        this.advogado = advogado;
        return this;
    }

    public TipoDeAcao getTipoDeAcao() {
        return tipoDeAcao;
    }

    public Processo setTipoDeAcao(TipoDeAcao tipoDeAcao) {
        this.tipoDeAcao = tipoDeAcao;
        return this;
    }


    @Override
    public String toString() {
        return "Processo{" +
                "id=" + getId() +
                ", numero='" + getNumero() + '\'' +
                ", proBono=" + getProBono() +
                ", advogado=" + getAdvogado() +
                ", tipoDeAcao=" + getTipoDeAcao() +
                '}';
    }
}
