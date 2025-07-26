create table respuestas (

    id bigint not null auto_increment,
    mensaje text not null,
    topico bigint not null,
    fechaCreacion datetime not null,
    autor bigint not null,

    primary key(id),
    constraint fk_respuestas_topico_id foreign key(topico) references topicos(id),
    constraint fk_respuestas_autor_id foreign key(autor) references usuarios(id)

);