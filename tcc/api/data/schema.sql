DROP TABLE IF EXISTS permissao CASCADE;
DROP TABLE IF EXISTS usuario CASCADE;
DROP TABLE IF EXISTS equipe CASCADE;
DROP TABLE IF EXISTS postagem CASCADE;
DROP TABLE IF EXISTS comentario CASCADE;
DROP TABLE IF EXISTS curtida CASCADE;
DROP TABLE IF EXISTS conexao CASCADE;


CREATE TABLE equipe (
	id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
	nome VARCHAR(100) NOT NULL,
	img VARCHAR(512) NOT NULL
);
ALTER TABLE equipe ADD CONSTRAINT pk_equipe PRIMARY KEY (id);
ALTER TABLE equipe ADD CONSTRAINT uk_equipe UNIQUE (nome);


CREATE TABLE usuario (
	id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
	nome VARCHAR(255) NOT NULL,
	email VARCHAR(255) NOT NULL,
	apelido VARCHAR(50),
	data_nascimento DATE NOT NULL,
	senha VARCHAR(128) NOT NULL,
	img VARCHAR(512),
	equipe_id BIGINT NOT NULL,
	ativo BOOLEAN NOT NULL
);
ALTER TABLE usuario ADD CONSTRAINT pk_usuario PRIMARY KEY (id);
ALTER TABLE usuario ADD CONSTRAINT uk_usuario_email UNIQUE (email);
ALTER TABLE usuario ADD CONSTRAINT fk_usuario_equipe FOREIGN KEY (equipe_id) REFERENCES equipe;


CREATE TABLE conexao (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    solicitador_id BIGINT NOT NULL,
    situacao VARCHAR(10) NOT NULL,
    solicitado_id BIGINT NOT NULL
);
ALTER TABLE conexao ADD CONSTRAINT pk_conexao PRIMARY KEY (id);
ALTER TABLE conexao ADD CONSTRAINT uk_solicitador_solicitaro UNIQUE (solicitador_id, solicitado_id);
ALTER TABLE conexao ADD CONSTRAINT ck_solicitacao CHECK (solicitador_id <> solicitado_id);
ALTER TABLE conexao ADD CONSTRAINT fk_conexao_solicitador FOREIGN KEY (solicitador_id) REFERENCES usuario;
ALTER TABLE conexao ADD CONSTRAINT fk_conexao_solicitado FOREIGN KEY (solicitado_id) REFERENCES usuario;
ALTER TABLE conexao ADD CONSTRAINT ck_situacao CHECK (situacao IN ('SOLICITADO', 'AMIZADE'));


CREATE TABLE postagem (
	id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
	usuario_id BIGINT NOT NULL,
	visualizacao VARCHAR(10) NOT NULL,
	titulo VARCHAR(50) NOT NULL,
	img VARCHAR(512),
	conteudo VARCHAR(500) NOT NULL,
	data_postagem TIMESTAMP NOT NULL
);
ALTER TABLE postagem ADD CONSTRAINT pk_postagem PRIMARY KEY (id);
ALTER TABLE postagem ADD CONSTRAINT fk_postagem_usuario FOREIGN KEY (usuario_id) REFERENCES usuario;
ALTER TABLE postagem ADD CONSTRAINT ck_postagem_visualizacao CHECK (visualizacao IN ('PUBLICO','PRIVADO'));


CREATE TABLE comentario (
	id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
	usuario_id BIGINT NOT NULL,
	postagem_id BIGINT NOT NULL,
	conteudo VARCHAR(500) NOT NULL,
	data_comentario TIMESTAMP NOT NULL
);
ALTER TABLE comentario ADD CONSTRAINT pk_comentario PRIMARY KEY (id);
ALTER TABLE comentario ADD CONSTRAINT fk_comentario_usuario FOREIGN KEY (usuario_id) REFERENCES usuario;
ALTER TABLE comentario ADD CONSTRAINT fk_comentario_postagem FOREIGN KEY (postagem_id) REFERENCES postagem;


CREATE TABLE curtida (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    postagem_id BIGINT NOT NULL,
    usuario_id BIGINT NOT NULL
);
ALTER TABLE curtida ADD CONSTRAINT pk_curtida PRIMARY KEY (id);
ALTER TABLE curtida ADD CONSTRAINT uk_curtida UNIQUE (postagem_id, usuario_id);
ALTER TABLE curtida ADD CONSTRAINT fk_curtida_postagem FOREIGN KEY (postagem_id) REFERENCES postagem;
ALTER TABLE curtida ADD CONSTRAINT fk_curtida_usuario FOREIGN KEY (usuario_id) REFERENCES usuario;


CREATE TABLE permissao (
	id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
	funcao VARCHAR(100) NOT NULL,
	usuario_id BIGINT NOT NULL
);
ALTER TABLE permissao ADD CONSTRAINT pk_permissao PRIMARY KEY (id);
ALTER TABLE permissao ADD CONSTRAINT uk_permissao UNIQUE (funcao, usuario_id);
ALTER TABLE permissao ADD CONSTRAINT fk_permissao_usuario FOREIGN KEY (usuario_id) REFERENCES usuario;
