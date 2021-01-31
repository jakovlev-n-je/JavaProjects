using System;
using System.Collections.Generic;
using System.Text;

namespace task1
{
    class Student
    {
        public string Name { get; set; }

        public string Surname { get; set; }

        public List<int> Marks { get; set; }

        public Student(string name, string surname, params int[] marks)
        {
            name = name.Trim().ToLower();
            Name = name[0].ToString().ToUpper() + name.Substring(1, name.Length - 1);
            surname = surname.Trim().ToLower();
            Surname = surname[0].ToString().ToUpper() + surname.Substring(1, surname.Length - 1);
            Marks = new List<int>(marks);
        }
    }

    public class Program
    {
        public static void Main()
        {
            StringBuilder invitation = new StringBuilder("Привет");
            List<Student> data = new List<Student>
            {
                new Student("иван", "иванов", 5, 4, 3),
                new Student("полина", "петрова", 3, 5, 5),
                new Student("сергей", "сидоров", 5, 5, 5),
                new Student("никита", "яковлев", 3, 4, 3)
            };
            for (int i = 0; i < data.Count; i++)
            {
                if (CalculateAverageMark(data[i].Marks) >= 4)
                {
                    invitation.Append($", {data[i].Surname} {data[i].Name[0]}.");
                }
            }
            invitation.Append("! Приходите к нам на интервью.");
            Console.WriteLine(invitation.ToString());
            Console.ReadKey();
        }

        public static int CalculateAverageMark(List<int> marks)
        {
            int sum = 0;
            foreach (int mark in marks)
            {
                sum += mark;
            }
            return sum / marks.Count;
        }
    }
}
