package br.com.fiap.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "T_TIPO_ACAO", uniqueConstraints = {
        @UniqueConstraint(name = "UK_TIPO_ACAO", columnNames = "NOME_TIPO_ACAO")
})

public class TipoDeAcao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TIPO_ACAO")
    @SequenceGenerator(name = "SQ_TIPO_ACAO", sequenceName = "SQ_TIPO_ACAO")
    @Column(name = "ID_TIPO_ACAO")
    private Long id;

    @Column(name = "NOME_TIPO_ACAO", nullable = false)
    private String nome;

    public TipoDeAcao() {
    }

    public TipoDeAcao(Long id, String nome) {
        this.setId(id);
        this.setNome(nome);
    }


    public Long getId() {
        return id;
    }

    public TipoDeAcao setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public TipoDeAcao setNome(String nome) {
        this.nome = nome;
        return this;
    }


    @Override
    public String toString() {
        return "TipoDeAcao{" +
                "id=" + getId() +
                ", nome='" + getNome() + '\'' +
                '}';
    }
}
