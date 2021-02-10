drop schema if exists obligatorisk1 cascade;

create schema obligatorisk1;
set search_path to obligatorisk1;

create type kjonn as enum ('mann', 'kvinne');

create table poststed
(
    postnr smallint not null,
    poststed varchar,

    constraint poststed_pk primary key (postnr)
);

create table ansatt
(
    ansnr serial not null,
    fornavn varchar,
    etternavn varchar,
    adresse varchar,
    fodselsdato date,
    kjonn kjonn,
    stilling varchar,
    aarslonn decimal,
    postnr smallint,

    constraint ansatt_pk primary key (ansNr),
    constraint ansatt_postnr_fk foreign key (postnr)
        references obligatorisk1.poststed (postnr) match simple
    on update cascade
);

create table kunde
(
    kundenr serial not null,
    fornavn varchar,
    etternavn varchar,
    adresse varchar,
    postnr smallint,

    constraint kunde_pk primary key (kundenr),
    constraint kunde_postnr_fk foreign key (postnr)
        references obligatorisk1.poststed (postnr) match simple
    on update cascade
);

create table ordre
(
    ordrenr serial not null,
    ordredato date,
    sendtdato date,
    betaltdato date,
    kundenr serial,

    constraint ordre_pk primary key (ordrenr),
    constraint ordre_kundenr_fk foreign key (kundenr)
        references obligatorisk1.kunde (kundenr) match simple
    on delete set null
);

create table kategori
(
    katnr serial not null,
    navn varchar,

    constraint kategori_pk primary key (katnr)
);

create table vare
(
    varenr serial not null,
    betegnelse varchar,
    pris decimal,
    antall integer,
    hylle varchar,
    katnr serial,

    constraint vare_pk primary key (varenr),
    constraint vare_katnr_fk foreign key (katnr)
        references obligatorisk1.kategori (katnr) match simple
);

create table ordrelinje
(
    ordrenr serial not null,
    varenr serial not null,
    prisperenhet decimal,
    antall integer,

    constraint ordrelinje_pk primary key (ordrenr, varenr),
    constraint ordrelinje_ordrenr_fk foreign key (ordrenr)
        references obligatorisk1.ordre (ordrenr) match simple
    on delete set null,
    constraint ordrelinje_varenr_fk foreign key (varenr)
        references obligatorisk1.vare (varenr) match simple
);

create table prishistorikk
(
    varenr serial not null,
    dato date,
    gemmelpris decimal,

    constraint prishistorikk_pk primary key (varenr, dato),
    constraint prishistorikk_varenr foreign key (varenr)
        references obligatorisk1.vare (varenr) match simple
);

insert into poststed values
(
    1234,
    'Oslo'
);

insert into ansatt values
(
    default,
    'Bob',
    'Kaare',
    'Snobbestad',
    '1995-01-01',
    'mann',
    'Snekker',
    200000,
     1234
);

insert into kunde values
(
    default,
    'Kunde',
    'Kundesen',
    'Kundestad',
    1234
);

insert into ordre values
(
    default,
    '2021-01-01',
    '2021-01-03',
    '2021-01-01',
    1
);

insert into kategori values
(
    default,
    'avfall'
);

insert into vare values
(
    default,
    'pyntepute',
    1000,
    150,
    'a13',
    1
);

insert into ordrelinje values
(
    1,
    1,
    (select pris from vare where betegnelse ='pyntepute'),
    2
);

insert into prishistorikk values
(
    1,
    '2002-05-05',
    800
);

alter table ansatt ADD COLUMN ansattdato date;
update ansatt set ansattdato = '2005-01-01' where ansnr = 1;
alter table ansatt alter column ansattdato set not null;

select * from kunde inner join ordre on kunde.kundenr = ordre.kundenr;
