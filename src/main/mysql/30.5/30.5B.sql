UPDATE STATS
	SET BESTSELLERS_COUNT = "Bestsellers"
    WHERE VALUE IN (bestsellers_count);
    
 COMMIT;
 
 SELECT * FROM STATS;
 
