create table classes
(
    id      int auto_increment
        primary key,
    libelle varchar(100) not null
);

create table enseignants
(
    id        int auto_increment
        primary key,
    nom       varchar(30)  null,
    prenom    varchar(30)  null,
    email     varchar(100) null,
    telephone varchar(20)  null
);

create table heures
(
    id      int auto_increment
        primary key,
    libelle varchar(100) not null
);

create table jours
(
    id      int auto_increment
        primary key,
    libelle varchar(100) not null
);

create table matieres
(
    libelle varchar(100) not null,
    id      int auto_increment
        primary key
);

create table matieres_enseignants
(
    matiere_id    int not null,
    enseignant_id int null,
    constraint matieres_enseignants_enseignants_id_fk
        foreign key (matiere_id) references enseignants (id),
    constraint matieres_enseignants_matieres_id_fk
        foreign key (matiere_id) references matieres (id)
);

create table programmations
(
    id            int auto_increment
        primary key,
    enseignant_id int not null,
    classe_id     int null,
    matiere_id    int not null,
    jour_id       int null,
    heure_id      int null,
    constraint programmations_classes_id_fk
        foreign key (classe_id) references classes (id),
    constraint programmations_enseignants_id_fk
        foreign key (enseignant_id) references enseignants (id),
    constraint programmations_heures_id_fk
        foreign key (heure_id) references heures (id),
    constraint programmations_jours_id_fk
        foreign key (jour_id) references jours (id),
    constraint programmations_matieres_id_fk
        foreign key (matiere_id) references matieres (id)
);

