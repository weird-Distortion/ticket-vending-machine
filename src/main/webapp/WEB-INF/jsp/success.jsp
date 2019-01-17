<%@ include file="common/header.jspf" %>

<div class="container">
  <div class="row">
    <div class="d-flex flex-column flex-container border border-danger rounded bg-info">
      <div class="p-2 bd-highlight tvm">Ticket Vending Machine</div>
      <div class="col-sm">
        <div class="ticket-option">${resultText}</div>
        <div class="info-option">You bought one <span class="argument">${ticketType}</span> ticket</div>
      </div>
      <div class="col-sm">
        <div class="ticket-option">Don't forget your money</div>
        <div class="info-option">
          <c:forEach items="${resultList}" var="coin">
            <span class="argument">${coin} |</span>
          </c:forEach>
        </div>
      </div>
      <div class="col-sm">
        <a href="index" class="btn btn-danger ticket-type-btn">Back</a>
      </div>
    </div>
  </div>
</div>

<%@ include file="common/footer.jspf" %>