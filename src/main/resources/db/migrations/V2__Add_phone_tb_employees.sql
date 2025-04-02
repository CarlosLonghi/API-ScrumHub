-- Migration para adicionar a coluna "phone" na tabela "tb_employees"

ALTER TABLE tb_employees
ADD COLUMN phone VARCHAR(50);