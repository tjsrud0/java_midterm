# java_midterm
## 기능

- 숫자 버튼 (0-9)
- 기본 연산자:
  - 더하기 (`+`)
  - 빼기 (`-`)
  - 곱하기 (`x`)
  - 나누기 (`/`)
- 계산 결과 표시
- 현재 입력값 수정 기능 (Backspace)
- 입력값 초기화 (C)
- 전체 초기화 (CE)

## 코드 설명
Calculator 클래스: JFrame을 확장하여 계산기 UI와 기능을 구현합니다.
displayField: 사용자 입력 및 계산 결과를 표시하는 텍스트 필드입니다.
buttons 배열: 숫자 및 연산자 버튼을 담고 있는 2D 배열입니다.
actionPerformed 메소드: 버튼 클릭 이벤트를 처리하여 계산을 수행합니다.
