BACKUPS
mysqldump -u root -p cbtlsdb > F:/MSCFinalProject/WebApplicationWorkspace/cbtls/DesignDiagrams/MasterDataFiles/empty_database.sql
mysqldump -u root -p cbtlsdb train_line > F:/MSCFinalProject/WebApplicationWorkspace/cbtls/DesignDiagrams/MasterDataFiles/train_line.sql

mysqldump -u root -p cbtlsdb > F:/MSCFinalProject/WebApplicationWorkspace/cbtls/DesignDiagrams/MasterDataFiles/db_trainlines_trainstations.sql



RESTORING
mysql -u root -p cbtlsdb < F:/MSCFinalProject/WebApplicationWorkspace/cbtls/DesignDiagrams/MasterDataFiles/empty_database.sql
mysql -u root -p cbtlsdb  < F:/MSCFinalProject/WebApplicationWorkspace/cbtls/DesignDiagrams/MasterDataFiles/train_line.sql


mysql -u root -p cbtlsdb  < F:/MSCFinalProject/WebApplicationWorkspace/cbtls/DesignDiagrams/MasterDataFiles/db_trainlines_trainstations.sql
