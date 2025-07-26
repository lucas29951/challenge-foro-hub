create table topicos (

    id bigint not null auto_increment,
    titulo varchar(200) not null,
    mensaje text not null,
    fechaCreacion datetime not null,
    status varchar(50) not null,
    autor bigint not null,
    curso bigint not null,

    primary key(id),
    constraint fk_topicos_usuario_id foreign key(autor) references usuarios(id),
    constraint fk_topicos_curso_id foreign key(curso) references cursos(id)

);