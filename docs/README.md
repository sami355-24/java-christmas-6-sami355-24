# 4주차

# 🥊 4주차 목표

✅ [3주차 피드백](https://docs.google.com/document/d/1Uhui2vf26U6t5XG4b1IvB26NtZR8as-QeU_ap_-Q6Y0/edit)

✅ 연관성이 있는 상수는 static final 대신 enum을 활용한다

✅ 객체는 객체스럽게 사용한다

> 데이터를 꺼내지(get) 말고 메시지를 던지도록 구조를 바꿔 데이터를 가지는 객체가 일하도록 한다.
>

✅ 단위 테스트하기 어려운 코드 작성하지 말기

✅ 함수명과 패키지명 지을때 누가봐도 이해하기 쉽게 작성하기

> 제네럴하게 작성할때와 자세하게 작성할때 구분하도록 노력
>

✅ 클래스에는 해당 클래스의 역할만 수행하도록 수행

✅ 클래스 내부 순서 신경쓰기

&nbsp;1️⃣ 변수

&nbsp;2️⃣ 생성자

&nbsp;3️⃣ 정적 메서드

&nbsp;4️⃣ 로직

&nbsp;5️⃣ 게터

&nbsp;6️⃣ 세터

---

# 📋 기능목록

## 예약 일자 - Reserved Date

- [x]  ✅ 날짜를 통해 `평일 할인`에 해당하는지 확인한다.
- [x]  ✅ 날짜를 통해 `주말할인`에 해당하는지 확인한다.
- [x]  ✅ 날짜를 통해 `특별 할인`에 해당되는지 확인한다.
- [x]  ✅ 날짜를 통해 `크리스마스 디데이 할인`에 해당되는지 확인한다.
- [x]  ✅ `숫자가 들어왔는지 검증한다`를 통해 예약 일자를 검증한다
- [x]  ✅ 날짜가 `1`에서 `31` 사이의 정수값인지 검증한다.

## 예약 메뉴 - Reserved Menus Group
- [x]  ✅ 예약하고자 하는 메뉴를 추가할 수 있다.
- [x]  ✅ `,`로 예약 메뉴별로 나눌 수 있다.
- [x]  ✅ `-`로 메뉴 이름과 수량을 나눌 수 있다.
- [x]  ✅ 예약한 메뉴이름과 예약한 메뉴의 수량을 받을 수 있다
- [x]  ✅ 예약한 메뉴중 디저트는 몇개가 있는지 확인한다
- [x]  ✅ 예약한 메뉴중 메인 메뉴는 몇개가 있는지 확인한다

## 예약 메뉴 검증 - Reserved Menu Group Validator
- [x]  ✅ 음료만 주문하였는지 검증한다
- [x]  ✅ 올바른 메뉴명으로 주문하였는지 검증한다.
- [x]  ✅ 주문한 메뉴의 수가 올바른 범위안에 존재하는지 검증한다
- [x]  ✅ 메뉴의 입력 형식이 올바른지 검증한다.
- [x]  ✅ 중복 메뉴가 입력되었는지 검증한다.

## 계산기 - Calculator
- [x]  ✅ 메뉴의 할인 전 금액을 구한다
- [x]  ✅ `크리스마스 디데이 할인` 으로 할인 받을 수 있는 금액을 구한다.
- [x]  ✅ `평일 할인`으로 할인받을 수 있는 금액을 구한다.
- [x]  ✅ `주말 할인`으로 할인 받을 수 있는 금액을 구한다.
- [x]  ✅ `특별 할인`으로 할인 받을 수 있는  금액을 구한다.
- [x]  ✅ `증정 이벤트`로 혜택받을 수 있는 금액을 구한다.
- [x]  ✅ `할인 후 예상 결제 금액 = 할인 전 총주문 금액 - 할인 금액` 수식 을 통해 할인 후 예상 결제 금액을 구할 수 있다.
- [x]  ✅ `총혜택 금액 = 할인 금액의 합계 + 증정 메뉴의 가격` 수식 을 통해 총 혜택 금액을 구할 수 있다.

## 이벤트 내역 - Applied Event Group

- [x]  ✅ 적용가능한 이벤트 내역을 추가 할 수 있다.
- [x]  ✅ 적용한 이벤트 내역을 건네줄 수 있다.
- [x]  ✅ 적용한 이벤트들을 통해 혜택 받는 가격을 반환한다.
- [x]  ✅ 적용받는 이벤트 금액을 통해 총 혜택 금액에 따른 12월 이벤트 배지 부여한다.
    - 5000원 이상 1만원 미만은 별 배지
    - 1만원 이상은 2만원 미만은 트리 배지
    - 2만원 이상은 산타 배지


## 예약 주문 - Reserved Order

- [x]  ✅ 할인을 받을 수 있는 최소 주문 금액을 넘었는지 확인한다
- [x]  ✅ 받을수 있는 할인들의 목록을 구한다.
- [x]  ✅ 계산기를 통해 `총 혜택 금액`을 구할 수 있다.
- [x]  ✅ 계산기를 통해 `할인 후 예상 결제 금액`을 구할 수 있다.
- [x]  ✅ 증정 메뉴를 반환한다.

## 입력 기능 - InputView
- [x]  ✅ 12월 중 식당 예상 방문 날짜를 입력받을 수 있다.
- [x]  ✅ 주문할 메뉴와 개수를 입력받을 수 있다.
- [x]  ✅ 예외 발생시 해당 부분부터 다시 입력을 받을 수 있다.

## 출력 기능 - OutPutView
- [x]  ✅ 사용자를 환영하는 문구를 출력한다
- [x]  ✅ 주문 메뉴를 출력한다.
- [x]  ✅ 할인 전 총 주문 금액을 출력한다
- [x]  ✅ 증정 메뉴에 대해 출력한다.
- [x]  ✅ 고객에게 적용된 이벤트 내역을 출력해준다.
- [x]  ✅ 총혜택 금액을 출력한다
- [x]  ✅ 할인후 예상 결제 금액을 출력한다
- [x]  ✅ 이벤트 배지를 출력한다
- [x]  ✅ 금액은 `1,000`원, `1,000,000`원 과 같이 표현한다

## 컨트롤러 - Controller

- [x]  ✅ 출력 기능를 통해 시작 문구를 출력한다.
- [x]  ✅ 입력 기능를 통해 날짜를 입력받는다.
- [x]  ✅ 입력 기능를 통해 메뉴를 입력받는다.
- [x]  ✅ 예약을 생성한다.
- [x]  ✅ 출력 기능를 통해 예약내역을 출력한다.
- [x]  ✅ 출력 기능를 통해 혜택 내역을 출력한다.

## 공통 검증 - CommonValidator
- [x]  ✅ 정수가 들어왔는지 검증한다
- [x]  ✅ 공백이 들어왔는지 검증한다
- [x]  ✅ 빈칸이 존재하는지 검증한다

## 변환 로직 - Utility
- [x]  ✅ 문자를 숫자로 바꾼다

---

# 🧪 테스트 목록

## 예약일자 테스트

- [x]  ☑️ `평일 할인`에 해당되는 날짜로 예약하였을때 평일 할인에 해당한다고 알려준다.
- [x]  ☑️ `주말 할인`에 해당되는 날짜로 예약하였을때 주말 할인에 해당한다고 알려준다.
- [x]  ☑️ `특별 할인`에 해당되는 날짜로 예약하였을때 특별 할인에 해당한다고 알려준다.
- [x]  ☑️ `크리스마스 할인`에 해당되는 날짜로 예약하였을때 특별 할인에 해당한다고 알려준다.
- [x]  ☑️ 날짜가 올바른 범위의 정수값인지 테스트한다
- [x]  ☑️ 정수 이외의 값이 입력되었을때 예외와 함께 적절한 문구가 출력되는지 테스트
- [x]  ☑️ 입력값이 정수지만 올바른 범위가 아닌 값이 입력되었을때 적절한 문구가 출력되는지 테스트

## 예약 메뉴 테스트

- [x]  ☑️ `,`로 예약 메뉴별로 나누는 기능 테스트한다.
- [x]  ☑️ `-`로 메뉴 이름과 수량을 나누는 기능 테스트한다.
- [x]  ☑️ 예약하고자 하는 메뉴와 수량이 정상적으로 동작하는지 테스트한다
- [x]  ☑️ 예약한 메뉴중 디저트 수를 구하는 로직이 올바른지 테스트한다
- [x]  ☑️ 예약한 메뉴중 메인 메뉴를 구하는 로직이 올바른지 테스트한다

## 예약 메뉴 검증 테스트

- [x]  ☑️ 음료만 주문했을때 예외를 발생시키는지 테스트한다.
- [x]  ☑️ 음료이외의 것을 음료와 함께 주문하였을때 올바르게 예약되는지 테스트한다
- [x]  ☑️ 음료이외의 것만 주문하였을때 올바르게 예약되는지 테스트한다.
- [x]  ☑️ 올바르지 못한 메뉴 명으로 주문하였을때 예외가 발생하는지 테스트한다.
- [x]  ☑️ 주문한 메뉴의 수가 올바른 범위 밖에 있을때 예외가 발생했는지 테스트한다.
- [x]  ☑️ 올바르지 못한 메뉴의 입력 형식으로 입력할때 예외가 발생하는지 확인한다
- [x]  ☑️ 중복 메뉴가 입력되었을때 예외가 발생하는지 확인한다

## 계산기 테스트

- [x]  ☑️ 메뉴의 할인 전 금액을 구하는 로직이 올바르게 동작하는지 확인한다
- [x]  ☑️ 크리스마스 디데이 할인으로 할인 받을수 있는 금액에 대한 로직을 테스트한다
- [x]  ☑️ 평일 할인으로 할인 받을 수 있는 금액에 대한 로직을 테스트한다
- [x]  ☑️ 주말 할인으로 할인 받을 수 있는 금액에 대한 로직을 테스트한다
- [x]  ☑️ 증정 이벤트으로 혜택 받을 수 있는 금액에 대한 로직을 테스트한다
- [x]  ☑️ 할인 후 예상 결제 금액을 구하는 로직에 대해 테스트를 한다
- [x]  ☑️ 총혜택 금액을 구하는 로직에 대해 테스트를 한다

## 예약 주문 테스트

- [x]  ☑️ 할인을 받을 수 있는 최종 금액을 넘지 못하였을때 할인을 받지 못하는지 테스트한다
- [x]  ☑️ 할인을 받을 수 있는 최종 금액을 넘었을때 할인을 받을수 있는지 테스트한다

## 이벤트 내역 테스트

- [x]  ☑️ 총 혜택 금액에 따라 올바른 배지를 받는지 테스트 한다.
- [x]  ☑️ 적용된 이벤트들의 합계 금액을 구한다.
- [x]  ☑️ 적용된 이벤트들의 금액들을 구한다.
- [x]  ☑️ 적용된 이벤트들의 목록을 구한다.

## 공통 검증 테스트

- [x]  ☑️ 정수이외의 것이 들어왔을때 예외가 발생하는지 테스트한다.
- [x]  ☑️ 정수가 들어왔을때 예외가 발생하지 않는지 테스트한다
- [x]  ☑️ 공백이 들어왔을때 예외가 발생하는지 테스트한다.
- [x]  ☑️ 공백없이 입력값이 들어왔을때 예외가 발생하지 않는지 테스트한다.
- [x]  ☑️ 빈칸이 존재때 예외가 발생하는지 테스트한다
- [x]  ☑️ 빈칸이 존재하지 않을때 예외가 발생하지 않는지 테스트한다.

## 변환 로직 테스트

- [x]  ☑️ 문자를 숫자로 정상적으로 바꾸는지 테스트한다.