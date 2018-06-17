TRUNCATE TABLE job RESTART IDENTITY CASCADE;
TRUNCATE TABLE domaine RESTART IDENTITY CASCADE;
TRUNCATE TABLE module RESTART IDENTITY CASCADE;
TRUNCATE TABLE prerequis RESTART IDENTITY CASCADE;
TRUNCATE TABLE job_parcours RESTART IDENTITY CASCADE;
TRUNCATE TABLE job_domaine RESTART IDENTITY CASCADE;
TRUNCATE TABLE module_parcours RESTART IDENTITY CASCADE;
TRUNCATE TABLE module_prerequis RESTART IDENTITY CASCADE;

INSERT INTO job (job_name) VALUES ('Administrateur de base de données');
INSERT INTO job (job_name) VALUES ('Administrateur de réseau');
INSERT INTO job (job_name) VALUES ('Architecte réseau');
INSERT INTO job (job_name) VALUES ('Chef de projet informatique');
INSERT INTO job (job_name) VALUES ('Développeur informatique');
INSERT INTO job (job_name) VALUES ('Expert en sécurité informatiques');
INSERT INTO job (job_name) VALUES ('Formateur en informatique');
INSERT INTO job (job_name) VALUES ('Gestionnaire de parc micro-informatique');
INSERT INTO job (job_name) VALUES ('Dev-ops');
INSERT INTO job (job_name) VALUES ('Ingénieur technico-commercial en informatique');
INSERT INTO job (job_name) VALUES ('Ingénieur en métrologie');
INSERT INTO job (job_name) VALUES ('Ingénieur télécoms et réseaux');
INSERT INTO job (job_name) VALUES ('Ingénieur électronicien');
INSERT INTO job (job_name) VALUES ('Ingénieure en systèmes embarqués');
INSERT INTO job (job_name) VALUES ('Ingénieure santée');

INSERT INTO domaine (domaine_name) VALUES ('Système embarqué');
INSERT INTO domaine (domaine_name) VALUES ('Télécom');
INSERT INTO domaine (domaine_name) VALUES ('Electronique');
INSERT INTO domaine (domaine_name) VALUES ('Informatique');


INSERT INTO parcours (parcours_name, parcours_link_isep) VALUES ('Architecte des systèmes d''information', 'https://www.isep.fr/cycle-ingenieur/parcours-architecte-des-systemes-dinformation/');
INSERT INTO parcours (parcours_name, parcours_link_isep) VALUES ('Ingénieur en business intelligence', 'https://www.isep.fr/cycle-ingenieur/parcours-ingenieur-en-business-intelligence/');
INSERT INTO parcours (parcours_name, parcours_link_isep) VALUES ('Architecte Télécom & IoT','https://www.isep.fr/cycle-ingenieur/parcours-architecte-telecom-iot-internet-des-objets/');
INSERT INTO parcours (parcours_name, parcours_link_isep) VALUES ('Ingénieur en sécurité numérique et réseaux','https://www.isep.fr/cycle-ingenieur/parcours-ingenieur-en-securite-numerique-et-reseaux/');
INSERT INTO parcours (parcours_name, parcours_link_isep) VALUES ('Concepteur de Systèmes Embarqués','https://www.isep.fr/cycle-ingenieur/parcours-ingenieur-en-conception-de-systemes-embarques/');
INSERT INTO parcours (parcours_name, parcours_link_isep) VALUES ('Innovation et Création d’entreprise','https://www.isep.fr/cycle-ingenieur/parcours-innovation-et-creation-dentreprise/');
INSERT INTO parcours (parcours_name, parcours_link_isep) VALUES ('Ingénieur logiciel','https://www.isep.fr/cycle-ingenieur/parcours-ingenieur-logiciel/');
INSERT INTO parcours (parcours_name, parcours_link_isep) VALUES ('Ingénieur numérique et santé','https://www.isep.fr/cycle-ingenieur/parcours-ingenieur-numerique-et-sante/');


INSERT INTO module (module_name, module_description) VALUES ('Méthodes et outils pour la BI', '');
INSERT INTO module (module_name, module_description) VALUES ('Analyse de données', '');
INSERT INTO module (module_name, module_description) VALUES ('Bases de données et Big Data', '');
INSERT INTO module (module_name, module_description) VALUES ('Algorithmique et programmation avancées', '');
INSERT INTO module (module_name, module_description) VALUES ('Architecture des systèmes d''information', '');
INSERT INTO module (module_name, module_description) VALUES ('Cybersécurité', '');
INSERT INTO module (module_name, module_description) VALUES ('Vision par ordinateur', '');
INSERT INTO module (module_name, module_description) VALUES ('Acquisition et traitement des données', '');
INSERT INTO module (module_name, module_description) VALUES ('Application Multimédia', '');
INSERT INTO module (module_name, module_description) VALUES ('Routage et Commutation', '');
INSERT INTO module (module_name, module_description) VALUES ('Sécurité réseaux', '');
INSERT INTO module (module_name, module_description) VALUES ('Réseaux d''objets communicants', '');
INSERT INTO module (module_name, module_description) VALUES ('Technologies mobiles cellulaires', '');
INSERT INTO module (module_name, module_description) VALUES ('Communications radios', '');

INSERT INTO module (module_name, module_description) VALUES ('Systèmes Radiofréquences', '');
INSERT INTO module (module_name, module_description) VALUES ('Électronique des objets', '');
INSERT INTO module (module_name, module_description) VALUES ('Instrumentation et systèmes pour la santé', '');
INSERT INTO module (module_name, module_description) VALUES ('Microsystèmes électroniques', '');
INSERT INTO module (module_name, module_description) VALUES ('Microsystèmes informatiques', '');
INSERT INTO module (module_name, module_description) VALUES ('Électronique numérique rapide', '');
INSERT INTO module (module_name, module_description) VALUES ('Architectures et Programmation distribuées', '');
INSERT INTO module (module_name, module_description) VALUES ('Technologies web avancées', '');
INSERT INTO module (module_name, module_description) VALUES ('Applications mobiles', '');
INSERT INTO module (module_name, module_description) VALUES ('Organisation des entreprises et des SI', '');
INSERT INTO module (module_name, module_description) VALUES ('Langages et compilation', '');
INSERT INTO module (module_name, module_description) VALUES ('Approches formelles', '');
INSERT INTO module (module_name, module_description) VALUES ('Gestion des risques et Audit', '');
INSERT INTO module (module_name, module_description) VALUES ('Web sémantique et Gestion de connaissances', '');
INSERT INTO module (module_name, module_description) VALUES ('Robotique pour la médecine', '');
INSERT INTO module (module_name, module_description) VALUES ('3D, Réalités mixte et augmentée', '');
INSERT INTO module (module_name, module_description) VALUES ('Machine learning', '');
INSERT INTO module (module_name, module_description) VALUES ('Traitement de l''information & haut débit', '');
INSERT INTO module (module_name, module_description) VALUES ('Services et technologies convergentes', '');
INSERT INTO module (module_name, module_description) VALUES ('Routage et architectures avancés', '');

INSERT INTO prerequis (prerequis_name,typeEvaluation,requis) VALUES ('ALGORITHMIQUE ET PROGRAMMATION','notes','12');
INSERT INTO prerequis (prerequis_name,typeEvaluation,requis) VALUES ('PROBABILITE','notes','12');

INSERT INTO job_parcours (job_id, parcours_id) VALUES ('1', '2');
INSERT INTO job_parcours (job_id, parcours_id) VALUES ('2', '4');
INSERT INTO job_parcours (job_id, parcours_id) VALUES ('3', '1');
INSERT INTO job_parcours (job_id, parcours_id) VALUES ('3', '4');
INSERT INTO job_parcours (job_id, parcours_id) VALUES ('4', '1');
INSERT INTO job_parcours (job_id, parcours_id) VALUES ('4', '7');
INSERT INTO job_parcours (job_id, parcours_id) VALUES ('5', '1');
INSERT INTO job_parcours (job_id, parcours_id) VALUES ('5', '2');
INSERT INTO job_parcours (job_id, parcours_id) VALUES ('5', '5');
INSERT INTO job_parcours (job_id, parcours_id) VALUES ('5', '7');
INSERT INTO job_parcours (job_id, parcours_id) VALUES ('5', '8');
INSERT INTO job_parcours (job_id, parcours_id) VALUES ('6', '4');
INSERT INTO job_parcours (job_id, parcours_id) VALUES ('7', '1');
INSERT INTO job_parcours (job_id, parcours_id) VALUES ('7', '2');
INSERT INTO job_parcours (job_id, parcours_id) VALUES ('7', '3');
INSERT INTO job_parcours (job_id, parcours_id) VALUES ('7', '4');
INSERT INTO job_parcours (job_id, parcours_id) VALUES ('7', '5');
INSERT INTO job_parcours (job_id, parcours_id) VALUES ('7', '6');
INSERT INTO job_parcours (job_id, parcours_id) VALUES ('7', '7');
INSERT INTO job_parcours (job_id, parcours_id) VALUES ('7', '8');
INSERT INTO job_parcours (job_id, parcours_id) VALUES ('8', '1');
INSERT INTO job_parcours (job_id, parcours_id) VALUES ('8', '3');
INSERT INTO job_parcours (job_id, parcours_id) VALUES ('9', '1');
INSERT INTO job_parcours (job_id, parcours_id) VALUES ('9', '7');
INSERT INTO job_parcours (job_id, parcours_id) VALUES ('10', '1');
INSERT INTO job_parcours (job_id, parcours_id) VALUES ('11', '1');
INSERT INTO job_parcours (job_id, parcours_id) VALUES ('11', '3');
INSERT INTO job_parcours (job_id, parcours_id) VALUES ('12', '3');
INSERT INTO job_parcours (job_id, parcours_id) VALUES ('12', '5');
INSERT INTO job_parcours (job_id, parcours_id) VALUES ('12', '6');
INSERT INTO job_parcours (job_id, parcours_id) VALUES ('14', '5');
INSERT INTO job_parcours (job_id, parcours_id) VALUES ('15', '8');

INSERT INTO job_domaine (job_id, domaine_id) VALUES ('1', '4');
INSERT INTO job_domaine (job_id, domaine_id) VALUES ('2', '2');
INSERT INTO job_domaine (job_id, domaine_id) VALUES ('3', '2');
INSERT INTO job_domaine (job_id, domaine_id) VALUES ('4', '4');
INSERT INTO job_domaine (job_id, domaine_id) VALUES ('5', '4');
INSERT INTO job_domaine (job_id, domaine_id) VALUES ('6', '2');
INSERT INTO job_domaine (job_id, domaine_id) VALUES ('6', '4');
INSERT INTO job_domaine (job_id, domaine_id) VALUES ('7', '4');
INSERT INTO job_domaine (job_id, domaine_id) VALUES ('8', '4');
INSERT INTO job_domaine (job_id, domaine_id) VALUES ('9', '4');
INSERT INTO job_domaine (job_id, domaine_id) VALUES ('10', '4');
INSERT INTO job_domaine (job_id, domaine_id) VALUES ('11', '3');
INSERT INTO job_domaine (job_id, domaine_id) VALUES ('12', '2');
INSERT INTO job_domaine (job_id, domaine_id) VALUES ('13', '1');
INSERT INTO job_domaine (job_id, domaine_id) VALUES ('13', '3');
INSERT INTO job_domaine (job_id, domaine_id) VALUES ('14', '1');
INSERT INTO job_domaine (job_id, domaine_id) VALUES ('14', '3');
INSERT INTO job_domaine (job_id, domaine_id) VALUES ('15', '3');
INSERT INTO job_domaine (job_id, domaine_id) VALUES ('15', '4');

INSERT INTO module_parcours (module_id, parcours_id) VALUES ('1', '1');
INSERT INTO module_parcours (module_id, parcours_id) VALUES ('2', '1');
INSERT INTO module_parcours (module_id, parcours_id) VALUES ('2', '2');

INSERT INTO module_prerequis (module_id,prerequis_id) VALUES ('1','1');
INSERT INTO module_prerequis (module_id,prerequis_id) VALUES ('1','2');