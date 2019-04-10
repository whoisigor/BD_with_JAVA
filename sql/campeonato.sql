create database campeonato;

create table Time (
	cod integer,
    nome varchar(45) not null,
    data_fundacao varchar(45) not null,
    primary key(cod)
);

create table Jogador (
	cod integer,
    time_cod integer,
    nome varchar(45) not null,
    idade integer not null,
    constraint FK_time_cod_de_Time foreign key (time_cod)
		references Time(cod),
    primary key(cod)
);

create table Jogo (
	cod integer,
    timea_cod integer not null,
    timeb_cod integer not null,
    resultado varchar(45) not null,
    constraint FK_timea_cod_de_Time foreign key (timea_cod)
		references Time(cod),
	constraint FK_timeb_cod_de_Time foreign key (timeb_cod)
		references Time(cod),
    primary key(cod)
);

create table JogadorParticipante (
	cod_participacao integer,
    Jogo_cod integer not null,
    Jogador_cod integer,
    constraint FK_Jogo_cod_de_Jogo foreign key (Jogo_cod)
		references Jogo(cod),
	constraint FK_Jogador_cod_de_Jogo foreign key (Jogador_cod)
		references Jogador(cod),
    primary key (cod_participacao)
);