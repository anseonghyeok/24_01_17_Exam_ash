import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("== 명언 앱 실행 ==");

		int lastId = 1;
		Scanner sc = new Scanner(System.in);
		ArrayList<WiseSaying> wiseSayings = new ArrayList<>();

		while (true) {
			System.out.print("명령어 )");
			String cmd = sc.nextLine().trim();

			if (cmd.length() == 0) {
				System.out.println("명령어를 입력해주세요");
				continue;
			}

			if (cmd.equals("종료")) {
				System.out.println("시스템이 종료됩니다");
				break;
			}

			if (cmd.equals("등록")) {

				System.out.println("명언 :");
				String content = sc.nextLine();
				System.out.println("작가 :");
				String auhtor = sc.nextLine();
				LocalDateTime now = LocalDateTime.now();
				String regDate = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

				WiseSaying wiseSaying = new WiseSaying(lastId, auhtor, content, regDate);

				wiseSayings.add(wiseSaying);

				System.out.println(lastId + "번 명언이 등록되었습니다");
				lastId++;

			}

			else if (cmd.equals("목록")) {

				System.out.println("번호  /  작가  /  명언  ");
				System.out.println("============================");

				for (int i = wiseSayings.size() - 1; i >= 0; i--) {
					WiseSaying ws = wiseSayings.get(i);
					System.out.printf("%d  /  %s  /  %s  \n", ws.getId(), ws.getAuthor(), ws.getContent());

				}

			} else if (cmd.startsWith("수정")) {
				int id = -1;
				WiseSaying findbyid = null;

				String[] cmdBits = cmd.split("\\?", 2);

				if (cmdBits.length == 1) {
					System.out.println("명령어를 다시 입력해주세요");
					continue;
				}
				String[] cmdBits2 = cmdBits[1].split("\\=", 2);

				id = Integer.parseInt(cmdBits2[1]);

				if (id == -1) {
					System.out.println("정수를 입력해주세요");
					continue;
				}

				for (WiseSaying wiseSaying : wiseSayings) {
					if (wiseSaying.getId() == id) {
						findbyid = wiseSaying;
						break;
					}
				}

				if (findbyid == null) {
					System.out.println(id + "번 명언은 존재하지 않습니다");
					continue;
				}

				System.out.printf("명언(기존) :%s \n", findbyid.getContent());
				System.out.printf("작가(기존) :%s \n", findbyid.getAuthor());
				System.out.println("명언 :");
				String content = sc.nextLine();
				System.out.println("작가 :");
				String author = sc.nextLine();

				findbyid.setContent(content);
				findbyid.setAuthor(author);

				System.out.println(id + "번 명언이 수정되었습니다");

			}

			else if (cmd.startsWith("상세보기")) {
				int id = -1;
				WiseSaying findbyid = null;

				String[] cmdBits = cmd.split("\\?", 2);

				if (cmdBits.length == 1) {
					System.out.println("명령어를 다시 입력해주세요");
					continue;
				}
				String[] cmdBits2 = cmdBits[1].split("\\=", 2);

				id = Integer.parseInt(cmdBits2[1]);

				if (id == -1) {
					System.out.println("정수를 입력해주세요");
					continue;
				}

				for (WiseSaying wiseSaying : wiseSayings) {
					if (wiseSaying.getId() == id) {
						findbyid = wiseSaying;
						break;
					}
				}

				if (findbyid == null) {
					System.out.println(id + "번 명언은 존재하지 않습니다");
					continue;
				}

				System.out.printf("번호 :%d\n", findbyid.getId());
				System.out.printf("날짜 :%s\n", findbyid.getRegDate());
				System.out.printf("작가 :%s\n", findbyid.getAuthor());
				System.out.printf("내용 :%s\n", findbyid.getContent());

			}

			else if (cmd.startsWith("삭제")) {
				int id = -1;
				WiseSaying findbyid = null;

				String[] cmdBits = cmd.split("\\?", 2);

				if (cmdBits.length == 1) {
					System.out.println("명령어를 다시 입력해주세요");
					continue;
				}
				String[] cmdBits2 = cmdBits[1].split("\\=", 2);

				id = Integer.parseInt(cmdBits2[1]);

				if (id == -1) {
					System.out.println("정수를 입력해주세요");
					continue;
				}

				for (WiseSaying wiseSaying : wiseSayings) {
					if (wiseSaying.getId() == id) {
						findbyid = wiseSaying;
						break;
					}
				}

				if (findbyid == null) {
					System.out.println(id + "번 명언은 존재하지 않습니다");
					continue;
				}

				wiseSayings.remove(findbyid);
				System.out.println(id + "번 명언이 삭제되었습니다");

			}

			else {
				System.out.println("없는 명령어 입니다");
				continue;
			}
		}
	}
}
