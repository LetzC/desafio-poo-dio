package br.com.dio.desafio.dominio;

import java.util.HashMap;
import java.util.Map;

public abstract class Conteudo {

    protected static final double XP_PADRAO = 10d;

    private String titulo;
    private String descricao;
    private Map<Dev, Double> avaliacoes = new HashMap<>();
    private double avaliacao = 0.0;

    public abstract double calcularXp();

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void adicionarAvaliacao(Dev dev, double avaliacao) {
        if (avaliacoes.containsKey(dev)) {
            // Atualiza a avaliação se o Dev já avaliou o conteúdo
            avaliacoes.put(dev, avaliacao);
        } else {
            // Adiciona uma nova avaliação se o Dev ainda não avaliou o conteúdo
            avaliacoes.put(dev, avaliacao);
        }
        this.avaliacao = calcularAvaliacao();
    }

    public double calcularAvaliacao() {
        if (avaliacoes.isEmpty()) {
            return 0;
        }
        double total = 0;
        for (double avaliacao : avaliacoes.values()) {
            total += avaliacao;
        }
        return total / avaliacoes.size();
    }

    public double getAvaliacao() {
        return avaliacao;
    }
}
