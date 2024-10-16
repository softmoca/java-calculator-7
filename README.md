# java-calculator-precourse


# 문자열 덧셈 계산기

## 구현할 기능 목록

#### 1. **입력값 처리**:
    - 사용자로부터 문자열 입력을 받는다.
    - `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 사용하여 입력을 처리한다.

#### 2. **기본 구분자(쉼표, 콜론)로 문자열 분리**:
    - 입력된 문자열에서 쉼표(`,`) 또는 콜론(`:`)을 구분자로 하여 숫자를 분리한다.
    - 분리된 숫자들을 더한 결과를 반환한다.
    - 예: `1,2:3` => 6

#### 3. **커스텀 구분자 처리**:
    - 문자열 앞부분에 `"//[커스텀 구분자]\\n"` 형태로 커스텀 구분자가 주어지면, 해당 구분자를 사용하여 문자열을 분리한다.
    - 예: `"//;\\n1;2;3"` => 6

#### 4. **빈 문자열 처리**:
    - 빈 문자열이 입력된 경우, 결과는 `0`을 반환한다.
    - 예: `""` => 0

#### 5. **음수에 대한 예외 처리**:
    - 음수가 입력된 경우, `IllegalArgumentException`을 발생시킨다.

#### 6. **덧셈 결과 출력**:
    - 계산된 결과를 `"결과 : [숫자]"` 형식으로 출력한다.
    - 예: `1,2:3` => `"결과 : 6"`

#### 7. **사용자가 잘못된 값을 입력하는 경우 예외 처리**:

7-1. 기본 구분자 또는 커스텀 구분자를 올바르게 사용했는지 확인

    7-1-1. 문자열 앞부분의 "//"로 시작하는 커스텀 구분자인지 확인
    - 7-1-1-1. `"//"`로 시작했지만, `"\n"`이 올바른 위치에 없을 경우.
    - 7-1-1-2. `"//\n"`처럼 구분자 없이 줄바꿈만 있는 경우.
    - 7-1-1-3. 구분자로 사용할 수 없는 형식의 데이터가 들어간 경우 (문자만 가능).
        - 7-1-1-3-1. 1~9 사이의 숫자 문자가 포함된 경우.
        - 7-1-1-3-2. 커스텀 구분자의 길이가 2 이상인 경우 (예: "//ab\n").
    - 7-1-1-4. 구분자는 있지만 숫자가 입력되지 않은 경우.
        - 예: `"//;\n;;"`처럼 구분자는 있지만 숫자가 전혀 입력되지 않은 경우.

7-2. 기본 구분자 또는 커스텀 구분자를 올바르게 사용하여 토큰화한 경우

- 7-2-1. 구분자가 입력된 숫자 사이에 없는 경우.
    - 숫자와 숫자 사이에 구분자가 없을 때.
    - 예: `"123"`처럼 구분자가 없고 하나의 숫자로 간주되는 경우.

- 7-2-2. 숫자가 아닌 값이 입력된 경우.
    - 구분자는 올바르게 사용되었으나, 숫자가 아닌 값이 포함된 경우.
    - 예: `"1,2,abc"`처럼 알파벳이나 특수 문자가 포함된 경우.

- 7-2-3. 음수 값이 입력된 경우.
    - 음수 값이 입력되면 예외 처리.
    - 추가적으로, 사용자에게 음수 값의 목록을 제공할 수 있음.

- 7-2-4. 연속된 구분자가 사용된 경우.
    - 연속된 구분자가 여러 번 반복된 경우.
    - 예: `"1,,2"` 또는 `"1::3"`처럼 쉼표나 콜론이 연속적으로 사용된 경우.
    - 예: `["1", "", "2"]`에서 빈 문자열 `""`는 0으로 처리.

7-3. 추가적인 문법적 예외 처리
- `int` 대신 `long` 또는 `BigInteger`를 사용 가능.
- `Console.readLine()`으로 입력받는 문자열의 이론적 최대 길이를 고려 (`Integer.MAX_VALUE`).
