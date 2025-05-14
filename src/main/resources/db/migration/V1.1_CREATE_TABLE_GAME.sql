create table game (
    idt_game numeric(10,0),
    des_name varchar(50) not null,
    num_peso numeric(10,0) not null,
    des_type varchar(50) not null,
    num_min_players numeric(10,0) not null,
    num_max_players numeric(10,0) not null,
    primary key (idt_game)
--    num_version numeric(10,0) DEFAULT 0 not null,
--    dat_creation timestamp not null,
--    dat_update timestamp not null,
--    flg_active boolean not null,
);

create table matches (
    idt_match numeric(10,0),
    idt_game numeric(10,0),
    des_initial_date varchar not null,
    des_final_date varchar not null,
    primary key (idt_match),
    constraint fk_game_match
        foreign key(idt_game)
            references game(idt_game)

--    num_version numeric(10,0) DEFAULT 0 not null,
--    dat_creation timestamp not null,
--    dat_update timestamp not null,
--    flg_active boolean not null,
);

create table player (
    idt_player numeric(10,0),
    idt_match numeric(10,0),
    des_name varchar(50) not null,
    primary key (idt_player),
    constraint fk_player_match
        foreign key(idt_player)
            references match(idt_match)
);