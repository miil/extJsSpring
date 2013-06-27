/**
 * Execute this script before before run the app 
 * Database: MySQL
 * 
 * @Author: Oleg B.
 * 
 * Create table MySql script
 */

DROP TABLE IF EXISTS `braziljs`.`L7_SERVICE_CONFIG`;
/**
 * Execute this script before before run the app 
 * Database: MySQL
 * 
 * @Author: Oleg B.
 * 
 * Create table MySql script
 */

DROP TABLE IF EXISTS `braziljs`.`L7_SERVICE_CONFIG`;
CREATE TABLE  `braziljs`.`L7_SERVICE_CONFIG` (
  L7_SERVICE_CONFIG_ID int(11) NOT NULL AUTO_INCREMENT,
  SERVICE_NAME                    VARCHAR(250) NOT NULL,
  CONNECTION_ROUTE_NAME           VARCHAR(1000),
  IS_ASYNC                        CHAR(1),
  ETA                             NUMBER,
  INVOCATIONS_PER_MINUTE          NUMBER,
  IS_PARSED                       VARCHAR(30),
  PARAMETER_LIST                  VARCHAR(4000),
  SOURCE_ENCODING                 VARCHAR(30),
  TARGET_ENCODING                 VARCHAR(30),
  METHOD                          VARCHAR(30),
  QUERY_STRING                    VARCHAR(4000),
  URL_ENCODING                    VARCHAR(5),
  SERVICE_NAME_CONCURRENCY_LIMIT  NUMBER(22),
  BACK_END_CONCURRENCY_LIMIT      NUMBER(22),
  QDRAIN_SERVICE_NAME_C_L         NUMBER(22),
  QDRAIN_BACK_END_C_L             NUMBER(22),
  SHOULD_RENDER                   CHAR(1),
  TIMEOUT_CUSTOMER                NUMBER,
  TIMEOUT_PROVIDER                NUMBER,
  ETA_DEVIDER                     NUMBER,
  SERVICE_NAME_SYNC_CONC          NUMBER,
  SERVICE_NAME_ASYNC_CONC         NUMBER  
  
  PRIMARY KEY (L7_SERVICE_CONFIG_ID)
) 
ENGINE=InnoDB;


