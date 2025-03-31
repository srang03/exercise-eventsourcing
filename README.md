# 프로젝트 분석 보고서

## 1. 프로젝트 구조

이 프로젝트는 이벤트 기반 아키텍처를 사용한 Spring 애플리케이션으로, 다음과 같은 모듈로 구성되어 있습니다:

- **app-api**: 외부 API 요청을 처리하는 모듈
- **command-module**: 명령 처리 로직이 포함된 모듈
- **query-module**: 조회 작업을 처리하는 모듈
- **common-module**: 공통 기능과 DTO가 포함된 모듈

## 2. 주요 컴포넌트

### 2.1 컨트롤러 레이어
- `LicenseQueryController`: 라이선스 정보를 조회하기 위한 REST API 제공
  - `GET /licenses/{licenseId}`: ID로 라이선스 조회
  - `GET /licenses/issuedTo/{issuedTo}`: 사용자명으로 라이선스 목록 조회

### 2.2 서비스 레이어
- `LicenseQueryService`: 라이선스 조회 서비스
- `LicenseApplicationService`: 라이선스 관련 명령(생성 등)을 처리하는 서비스

### 2.3 명령 처리 (CQRS 패턴)
- `CreateLicenseCommand`: 라이선스 생성 명령
- `CreateLicenseCommandHandler`: 명령 처리기
- `LicenseAggregate`: 라이선스 애그리게이트

### 2.4 이벤트 처리
- `LicenseEvent`: 라이선스 관련 이벤트

### 2.5 쿼리 처리
- `LicenseProjection`: 라이선스 데이터 조회 모델
- `LicenseProjectionRepository`: 라이선스 조회 저장소
- `DefaultLicenseProjectionHandler`: 라이선스 프로젝션 처리기

## 3. 아키텍처 패턴

이 프로젝트는 CQRS(Command Query Responsibility Segregation) 패턴과 이벤트 소싱을 활용하고 있습니다:

### 3.1 명령 흐름
클라이언트 → Controller → ApplicationService → CommandHandler → Aggregate → Event 발행

### 3.2 쿼리 흐름
클라이언트 → QueryController → QueryService → Repository → Projection 반환

### 3.3 이벤트 처리
Event → ProjectionHandler → Repository 업데이트

## 4. 기술 스택
- Java 21
- Spring MVC
- Spring Data JPA
- Lombok
- Jakarta EE

## 5. 종합 분석

이 프로젝트는 라이선스 관리 시스템으로, 라이선스 생성 및 조회 기능을 제공합니다. 이벤트 기반 아키텍처를 통해 명령과 쿼리를 분리하여 확장성과 유연성을 높인 구조로 설계되어 있습니다. CQRS 패턴과 이벤트 소싱을 통해 시스템의 상태 변화를 추적하고 관리하는 방식을 채택하고 있습니다.
