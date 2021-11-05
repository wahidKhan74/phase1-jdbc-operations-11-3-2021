use ecomdb;

DELIMITER &&
create procedure get_all_products_and_count()
begin 
 select * from ecomdb.eproducts;
 select count(pid) as total_product from ecomdb.eproducts;
 end &&
DELIMITER ;

---

use ecomdb;

DELIMITER &&
create procedure add_products(IN productName varchar(100), IN productPrice decimal(10,2))
begin 
 insert into ecomdb.eproducts(name, price) values(productName,productPrice);
 end &&
DELIMITER ;

