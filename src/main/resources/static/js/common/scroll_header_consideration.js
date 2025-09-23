const headerHeight = 80;
  document.querySelectorAll('a[href^="#"]').forEach(anchor => {
      anchor.addEventListener("click", function(e) {
        e.preventDefault();
        const target = document.querySelector(this.getAttribute("href"));
        if (target) {
          const targetTop = target.getBoundingClientRect().top + window.scrollY;
          const scrollY = Math.min(
            targetTop - headerHeight,
            document.body.scrollHeight - window.innerHeight
          );
          window.scrollTo({ top: scrollY, behavior: "smooth" });
        }
      });
    });