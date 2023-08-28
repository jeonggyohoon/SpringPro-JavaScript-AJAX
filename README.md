<!-- head -->
<p align="center">
  <img src="https://capsule-render.vercel.app/api?type=waving&color=auto&height=200&section=header&text=API와&nbsp;BootStrap을&nbsp;활용한&nbsp;게시판&fontSize=42" />
</p>

<!-- body -->

**기술 스택**
- *Spring FramWork 활용*
- *Java / JavaScript / AJAX*
- *HTML / CSS / JSP*
- *MySQL DB*
- *OPEN API*
- *BootStrap*
  


---
<br/>

  **담당**

- 로그인 기능 구현
- 게시판 리스트 출력, 등록, 수정, 삭제(비활성update)
- 게시물 검색, 페이징
- 상세페이지 출력, 댓글
- 위치 찾기, 검색(도서) 기능 구현(OPEN API)
- AJAX를 이용한 비동기 처리(SpringMVC05)

 --- 

<br/>

  **화면구현**
  
<br/>
  
<br/>

- 메인 페이지(리스트 출력, 로그인)

<br/>

![Spring](https://github.com/jeonggyohoon/MVC-pattern-imarket/assets/133930245/1ab44787-9211-4939-b423-f704c6ce7273)

> code location
>> views / boardList.jsp
>> views / left.jsp

<br/>

- 상세 페이지, 댓글 등록

<br/>

![Spring (5)](https://github.com/jeonggyohoon/MVC-pattern-imarket/assets/133930245/d13d38e5-8a9b-4901-9bbd-ade77e103e92)

> code location
>> views / get.jsp
>> views / reply.jsp

<br/>

- 위치 조회

<br/>

![Spring (2)](https://github.com/jeonggyohoon/MVC-pattern-imarket/assets/133930245/522f6d6d-cc11-42d7-b36f-aa76cc853cd1)

> code location
>> 출력위치 views / left.jsp
>> Script views / boardList.jsp
<br/>

- 도서 검색

<br/>

![Spring (3)](https://github.com/jeonggyohoon/MVC-pattern-imarket/assets/133930245/44abfdc2-be6e-4601-8efe-6f405d5cd3a1)

> code location
>> 출력위치 views / right.jsp
>> Script views / boardList.jsp
<br/>

---

**comment**

- OPEN API를 이용하여 불러온 리스트를 어떻게 처리할지 고민을 많이했다.

![13](https://github.com/jeonggyohoon/MVC-pattern-imarket/assets/133930245/cf89edb5-43be-4af6-a42f-4b103016ccf5)

#### 1. HTML을 동적으로 구축하여 지정 위치에 출력하는 방법이 있다.

![12](https://github.com/jeonggyohoon/MVC-pattern-imarket/assets/133930245/486787c5-3e02-4111-8a9c-32df411537b5)

#### 2. 또 다른 방법으로 별도의 JSP에서 리스트를 만들어 지정 위치로 보내주는 방법이 있다.(출력 값이 복잡할 경우 이 방법 추천!)
