DELIMITER $$

create trigger item_pedido_id_trigger
before insert on item_pedido for each row

begin

set NEW.id=uuid();

end;

$$ DELIMITER ;