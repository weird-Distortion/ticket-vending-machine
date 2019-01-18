<%@ include file="common/header.jspf" %>

<div class="container">
  <div class="row">
    <div class="d-flex flex-column flex-container border border-danger rounded bg-info">
      <div class="p-2 bd-highlight tvm">Ticket Vending Machine</div>
      <div class="col-sm">
        <div class="ticket-option">Tickets left: </div>
        <c:forEach items="${tickets}" var="pair">
          <div class="data-info">${pair.getKey()} : ${pair.getValue()} pcs</div>
        </c:forEach>
      </div>
      <div class="col-sm">
        <div class="ticket-option">Betelgeuse coins left: </div>
        <c:forEach items="${coins}" var="pair">
          <div class="data-info">${pair.getKey()} bg : ${pair.getValue()}</div>
        </c:forEach>
      </div>
      <div class="col-sm">
        <a href="/index" class="btn btn-warning ticket-type-btn">Back</a>
      </div>
    </div>
  </div>
</div>

<%@ include file="common/footer.jspf" %>