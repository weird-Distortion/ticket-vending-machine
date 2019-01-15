<%@ include file="common/header.jspf" %>

<div class="container">
  <div class="row">
    <div class="col-sm">
      <div>TVM</div>
      <div>Choose ticket:</div>
      <c:forEach items="${ticketTypes}" var="ticket">
        <div>
          <a href="/ticket?id=${ticket.name()}">${ticket.name()}</a>
        </div>
      </c:forEach>
      <div>
        <form:form method="post" modelAttribute="machine">
          <button class="btn btn-info" type="submit">Fill machine</button>
        </form:form>
      </div>
    </div>
  </div>
</div>

<%@ include file="common/footer.jspf" %>