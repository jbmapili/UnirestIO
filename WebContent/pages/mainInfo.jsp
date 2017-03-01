<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div>
	<c:forEach var="info" items="${information}">
	Name
	<label>${info.name}</label>
	Info
	<label>${info.info}</label>	
	Chapters: 
	<select id="chapters" class="form-control" onchange="selectChapter()">
		<c:forEach var="chapter" items="${info.chapters}">
			<option value="${chapter.chapterId}">
				<c:out value="${chapter.name}"></c:out>
			</option>
		</c:forEach>		
	</select> 
	</c:forEach>	
</div>