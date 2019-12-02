UPDATE STATS
	SET BESTSELLER_COUNT = "Bestsellers"
    WHERE VALUE IN (bestsellers_count);
    
 COMMIT;
 
 SELECT * FROM STATS;
 
