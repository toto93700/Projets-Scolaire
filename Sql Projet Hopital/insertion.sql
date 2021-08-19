insert into PATHOLOGIES values (1, 'fatigue du coeur');
insert into PATHOLOGIES values (2,'diabète');
insert into PATHOLOGIES values  (3,'insufisance reinal');
insert into PATHOLOGIES values  (4,'maladie denfant malade',4);

insert into SERS values  (1,1,0148,'cardiologie','1');
insert into SERS values  (2,2,0149,'pédiatrie','4');
insert into sers values (3,3,0150,'service liée au diabète',2);
insert into sers values (4,4,0160,'service liée au rein',3);


insert into SALLES values (0001,0001,5,0,1,1);
insert into SALLES values (0002,0002,10,0,3,2);
insert into SALLES values (0003,0003,5,0,4,3);
insert into SALLES values (0004,0004,5,0,2,4);


insert into PATIENTS values(2000,2000,1,'Jaimal','Ocoeur',1,10-10-2019);
insert into PATIENTS values(2001,2001,2,'Ouyo','Rein',3,09-12-2019,22-12-2019);
insert into PATIENTS values (2002,2002,3,'Fenen','Ladma',4,12-11-2019);
insert into PATIENTS values(2004,2004,2,'ayeo','neir',3,11-12-2019,21-12-2019);




insert into personnels values(222,222,44,'directeur','Boss','Mister');
insert into personnels  values(221,221,43,'medecin',1,44,'doc1nom','doc1prenom',1);
insert into personnels values(220,220,42,'infirmier'2,43,'infirmier1nom','infirmierprenom',4);
insert into personnels  values(219,219,41,'medecin',1,44,'doc2nom','doc2prenom',1);

insert into addresses(222,61,'delapaix','93','drancy');
insert into addresses(221,7,'croix','92','pigny');
insert into addresses(220,9,'touya','95','st-denis');
insert into addresses(219,42,'pablo','93','bobigny');
insert into addresses(2000,24,'ereyn','93','villetaneuse');
insert into addresses(2001,1,'pomps','94','sevran');
insert into addresses(2002,10,'reign','93','sevran');
insert into addresses(2004,6,'delapaix','93','drancy');


insert into NUMEROs (222,0666);
insert into NUMEROs (221,0666);
insert into NUMEROs (220,0666);
insert into NUMEROs (219,0666);
insert into NUMEROs (2004,0666);
insert into NUMEROs (2002,0666);
insert into NUMEROs (2001,0666);
insert into NUMEROs (2000,0666);

insert into SOINS(1,'soin du coeur',1);
insert into SOINS(4,'soin pour enfant',4);
insert into SOINS(3,'soin du rein ,'3);

insert into SOINS_MEDICAUX(1,1,1,0001,43,1,500,29-12-2019,1);
insert into SOINS_MEDICAUX(3,3,3,0002,41,3,450,30-12-2019,1);
insert into SOINS_MEDICAUX(4,4,4,0004,43,4,150,31-12-2019,1);