<%@ include file="common/header.jspf" %>

<div class="container">
  <div class="row">
    <div class="d-flex flex-column flex-container border border-danger rounded bg-info">
      <div class="p-2 bd-highlight tvm">Ticket Vending Machine</div>
      <div class="col-sm warn ticket-option">Canceling...</div>
      <div class="col-sm warn">
        <span class="ticket-option">Take your money back: </span>
        <c:forEach items="${userInputList}" var="userCoinValue">
          <span class="argument">${userCoinValue} |</span>
        </c:forEach>
      </div>
      <div class="col-sm ticket-logo">
        <form:form method="post" modelAttribute="userInputList">
          <div class="ticket-type">
            <form:button type="submit" path="coinValue" class="btn btn-success ticket-type-btn">Ok</form:button>
          </div>
        </form:form>
      </div>
    </div>
  </div>
</div>

<%@ include file="common/footer.jspf" %>