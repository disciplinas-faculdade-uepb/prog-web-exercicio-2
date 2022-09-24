CREATE TABLE IF NOT EXISTS public.teachers (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  mail VARCHAR(255) NOT NULL UNIQUE,
  formation VARCHAR(255) NOT NULL,
  register VARCHAR(255) NOT NULL UNIQUE
);