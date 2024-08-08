DECLARE
    v_age NUMBER;
    v_discount_rate NUMBER := 0.01;
BEGIN
    FOR customer_rec IN (SELECT CustomerID, DOB FROM Customers) LOOP
        v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, customer_rec.DOB) / 12);
        
        IF v_age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - (InterestRate * v_discount_rate)
            WHERE CustomerID = customer_rec.CustomerID;
        END IF;
    END LOOP;
    
    COMMIT;
END;
