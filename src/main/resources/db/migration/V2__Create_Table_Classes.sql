CREATE TABLE IF NOT EXISTS public.classes (
  id SERIAL PRIMARY KEY,
  teacher_id INT NOT NULL,
  discipline_name VARCHAR(255) NOT NULL,
  room VARCHAR(255) NOT NULL,
  CONSTRAINT fk_teacher_id 
  FOREIGN KEY(teacher_id) REFERENCES public.teachers(id)
);