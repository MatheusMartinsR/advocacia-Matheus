package br.com.fiap.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "T_ESTADO", uniqueConstraints = {
        @UniqueConstraint(name = "UK_NM_ESTADO", columnNames = {"NM_ESTADO"}),
        @UniqueConstraint(name = "UK_SIGLA_ESTADO", columnNames = {""})
})


public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ESTADO")
    @SequenceGenerator(name = "SQ_ESTADO", sequenceName = "SQ_ESTADO")
    @Column(name = "ID_ESTADO")
    private Long id;

    @Column(name = "NOME_ESTADO")
    private String nome;

    @Column(name = "SIGLA_ESTADO")
    private String sigla;

    public Estado() {
    }

    public Estado(Long id, String nome, String sigla) {
        this.setId(id);
        this.setNome(nome);
        this.setSigla(sigla);
    }


    public Long getId() {
        return id;
    }

    public Estado setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Estado setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getSigla() {
        return sigla;
    }

    public Estado setSigla(String sigla) {
        this.sigla = sigla;
        return this;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "id=" + getId() +
                ", nome='" + getNome() + '\'' +
                ", sigla='" + getSigla() + '\'' +
                '}';
    }
}
