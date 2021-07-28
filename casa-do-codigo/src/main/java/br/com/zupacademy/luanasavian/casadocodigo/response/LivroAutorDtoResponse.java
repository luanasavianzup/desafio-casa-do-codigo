package br.com.zupacademy.luanasavian.casadocodigo.response;

import br.com.zupacademy.luanasavian.casadocodigo.model.Autor;

public class LivroAutorDtoResponse {

        private String nome;
        private String descricao;

        public LivroAutorDtoResponse(Autor autor) {
            this.nome = autor.getNome();
            this.descricao = autor.getDescricao();
        }

        public String getNome() {
            return nome;
        }

        public String getDescricao() {
            return descricao;
        }

}
