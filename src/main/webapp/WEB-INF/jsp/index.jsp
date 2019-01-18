<%@ include file="common/header.jspf" %>

<div class="container">
  <div class="row">
    <div class="d-flex flex-column flex-container border border-danger rounded bg-info">
      <div class="p-2 bd-highlight tvm">Ticket Vending Machine</div>
      <div class="p-2 bd-highlight ticket-option">Choose ticket:</div>
      <div class="p-2 bd-highlight">
        <c:forEach items="${ticketTypes}" var="pair">
          <div class="ticket-type">
            <a href="/ticket?id=${pair.getKey()}" class="btn btn-warning ticket-type-btn">${pair.getValue()}</a>
          </div>
        </c:forEach>
      </div>
      <div class="fill-btn">
        <form:form method="post" modelAttribute="machine">
          <button class="btn btn-outline-dark btn-lg" type="submit">Fill machine</button>
        </form:form>
      </div>
      <div class="fill-btn">
        <a href="machine-data" class="btn btn-outline-dark btn-lg">Data</a>
      </div>
    </div>
  </div>
</div>

<%@ include file="common/footer.jspf" %>