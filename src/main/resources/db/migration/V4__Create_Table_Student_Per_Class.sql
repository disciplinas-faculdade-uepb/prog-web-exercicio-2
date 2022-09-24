CREATE TABLE IF NOT EXISTS public.student_per_class (
  id SERIAL PRIMARY KEY,
  classe_id INT NOT NULL,
  student_id INT NOT NULL,
  CONSTRAINT fk_classe_id
  FOREIGN KEY(classe_id) REFERENCES public.classes(id),
  CONSTRAINT fk_student_id
  FOREIGN KEY(student_id) REFERENCES public.students(id)
);