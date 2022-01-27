/*1. 학생정보들을 저장하고, 학생이름으로 검색했을때 학번을 출력하는 프로그램 작성.

- Student 클래스 생성
String name, no를 가짐 (이름과 학번)

학생들을 ArrayList에 저장1

검색을 하겠느냐 y
종료하고싶으면 n

학생이름이있는경우 그학생의 학번을 저장
학생이름이 없으면, 없는 학생이름이라고 출력

태그 while, flag, ArrayList, for each */
package algorithm_basic_100.no1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		ArrayList<Student> studentList = new ArrayList<>();

		Student st1 = new Student("손오공", "1234");

		studentList.add(st1);

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("검색을 하고 싶느냐");
			String inputContinue = sc.next();

			if (inputContinue.equals("y")) {
				System.out.println("검색을 시작합니다.");

				String inputName = sc.next();
				boolean flag = false;

				for (Student student : studentList) {
					if (student.getName().equals(inputName)) {
						System.out.println(student.getName() + " " + student.getNo());
						flag = true;
					}
				}

				if (!flag) {
					System.out.println("해당 학생이 없습니다.");
				}

			} else {
				System.out.println("검색중지");
				break;
			}
		}

	}

}
